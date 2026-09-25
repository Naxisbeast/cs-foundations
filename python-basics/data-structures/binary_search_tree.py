"""A binary search tree storing ints, with duplicate values ignored.

This is the Python mirror of the Java BinarySearchTree in
data-structures/tree/. Same behaviour, idiomatic Python.

Time complexity (balanced tree):
  insert/contains/min/max   O(log n) average, O(n) worst (skewed tree)
  in_order                  O(n)
  height                    O(n)

Design note: the Java version uses recursion throughout; this version
uses recursion for insert/traversal but iterative loops for contains,
min, and max, which is the idiomatic way to keep those O(1) in space.
"""


class BinarySearchTree:
    class _Node:
        __slots__ = ("value", "left", "right")

        def __init__(self, value):
            self.value = value
            self.left = None
            self.right = None

    def __init__(self):
        self._root = None
        self._size = 0

    def insert(self, value):
        """Insert a value. Returns True if added, False if already present."""
        size_before = self._size
        self._root = self._insert(self._root, value)
        return self._size > size_before

    def _insert(self, node, value):
        if node is None:
            self._size += 1
            return self._Node(value)
        if value < node.value:
            node.left = self._insert(node.left, value)
        elif value > node.value:
            node.right = self._insert(node.right, value)
        return node

    def contains(self, value):
        node = self._root
        while node is not None:
            if value == node.value:
                return True
            node = node.left if value < node.value else node.right
        return False

    def min(self):
        if self._root is None:
            raise ValueError("min of an empty tree")
        node = self._root
        while node.left is not None:
            node = node.left
        return node.value

    def max(self):
        if self._root is None:
            raise ValueError("max of an empty tree")
        node = self._root
        while node.right is not None:
            node = node.right
        return node.value

    def height(self):
        """Height: -1 for an empty tree, 0 for a single node."""
        return self._height(self._root)

    def _height(self, node):
        if node is None:
            return -1
        return 1 + max(self._height(node.left), self._height(node.right))

    def size(self):
        return self._size

    def is_empty(self):
        return self._size == 0

    def in_order(self):
        """In-order traversal: values come out in ascending order."""
        result = []
        self._in_order(self._root, result)
        return result

    def _in_order(self, node, result):
        if node is None:
            return
        self._in_order(node.left, result)
        result.append(node.value)
        self._in_order(node.right, result)


if __name__ == "__main__":
    tree = BinarySearchTree()
    for value in [5, 3, 8, 1, 4, 7, 9]:
        tree.insert(value)
    print("In-order:", tree.in_order())
    print("Size:", tree.size())
    print("Min:", tree.min())
    print("Max:", tree.max())
    print("Height:", tree.height())
    print("Contains 4:", tree.contains(4))
    print("Contains 6:", tree.contains(6))
