"""pytest tests for the Python data structures.

Same coverage as the Java JUnit suite - LIFO/FIFO ordering, empty-case
exceptions, and known results for search, sort, tree, map, and graph.
"""

import pytest

from stack import Stack
from queue import Queue
from binary_search import search, search_recursive
from merge_sort import sort as merge_sort
from binary_search_tree import BinarySearchTree
from hash_map import HashMapChaining
from graph import Graph


class TestStack:
    def test_lifo_order(self):
        stack = Stack()
        stack.push(10)
        stack.push(20)
        stack.push(30)
        assert stack.pop() == 30
        assert stack.pop() == 20
        assert stack.pop() == 10
        assert stack.is_empty()

    def test_peek_does_not_remove(self):
        stack = Stack()
        stack.push(7)
        stack.push(9)
        assert stack.peek() == 9
        assert stack.size() == 2

    def test_empty_pop_raises(self):
        with pytest.raises(IndexError):
            Stack().pop()

    def test_empty_peek_raises(self):
        with pytest.raises(IndexError):
            Stack().peek()


class TestQueue:
    def test_fifo_order(self):
        queue = Queue()
        queue.enqueue(100)
        queue.enqueue(200)
        queue.enqueue(300)
        assert queue.dequeue() == 100
        assert queue.dequeue() == 200
        assert queue.dequeue() == 300
        assert queue.is_empty()

    def test_peek_does_not_remove(self):
        queue = Queue()
        queue.enqueue(5)
        queue.enqueue(6)
        assert queue.peek() == 5
        assert queue.size() == 2

    def test_empty_dequeue_raises(self):
        with pytest.raises(IndexError):
            Queue().dequeue()


class TestBinarySearch:
    def test_found_and_missing(self):
        numbers = [2, 4, 6, 8, 10, 12, 14]
        assert search(numbers, 8) == 3
        assert search(numbers, 7) == -1
        assert search_recursive(numbers, 14) == 6

    def test_empty(self):
        assert search([], 1) == -1


class TestMergeSort:
    def test_sorts_unsorted(self):
        assert merge_sort([5, 2, 9, 1, 7, 3]) == [1, 2, 3, 5, 7, 9]

    def test_sorted_and_duplicates(self):
        assert merge_sort([1, 2, 3]) == [1, 2, 3]
        assert merge_sort([3, 1, 3, 2]) == [1, 2, 3, 3]


class TestBinarySearchTree:
    def test_insert_contains_and_duplicates(self):
        tree = BinarySearchTree()
        assert tree.insert(5)
        assert not tree.insert(5)   # duplicate ignored
        assert tree.contains(5)
        assert tree.size() == 1

    def test_in_order_and_min_max(self):
        tree = BinarySearchTree()
        for value in [50, 30, 70, 20, 40, 60, 80]:
            tree.insert(value)
        assert tree.in_order() == [20, 30, 40, 50, 60, 70, 80]
        assert tree.min() == 20
        assert tree.max() == 80


class TestHashMap:
    def test_put_get_update_remove(self):
        mapping = HashMapChaining(8)
        mapping.put("alpha", 1)
        mapping.put("beta", 2)
        mapping.put("alpha", 99)   # update in place
        assert mapping.get("alpha") == 99
        assert mapping.get("missing") is None
        assert mapping.remove("beta") is True
        assert mapping.remove("beta") is False
        assert mapping.size() == 1


class TestGraph:
    def test_bfs_and_dfs_order(self):
        graph = Graph()
        graph.add_edge(0, 1)
        graph.add_edge(0, 2)
        graph.add_edge(1, 3)
        graph.add_edge(2, 3)
        assert graph.bfs(0) == [0, 1, 2, 3]
        assert graph.dfs(0) == [0, 1, 3, 2]
