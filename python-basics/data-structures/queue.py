"""A simple FIFO queue backed by a deque.

This is the Python mirror of the Java QueueUsingArray in
data-structures/queue/. Same FIFO behaviour, idiomatic Python.

Operations and time complexity:
  enqueue(element)  O(1)
  dequeue()         O(1)
  peek()            O(1)
  is_empty()        O(1)
  size()            O(1)

Design note: the Java version is a fixed-capacity circular array that
reuses freed slots and reports when full. A deque is the production
choice here: it grows automatically and pops from the front in O(1),
which a plain list cannot do efficiently.
"""

from collections import deque


class Queue:
    def __init__(self):
        self._items = deque()

    def enqueue(self, element):
        self._items.append(element)

    def dequeue(self):
        if self.is_empty():
            raise IndexError("dequeue from an empty queue")
        return self._items.popleft()

    def peek(self):
        if self.is_empty():
            raise IndexError("peek on an empty queue")
        return self._items[0]

    def is_empty(self):
        return len(self._items) == 0

    def size(self):
        return len(self._items)

    def __str__(self):
        return f"Queue front -> rear: {list(self._items)}"


if __name__ == "__main__":
    queue = Queue()
    queue.enqueue(100)
    queue.enqueue(200)
    queue.enqueue(300)
    print(queue)
    print("Front value:", queue.peek())
    print("Dequeued value:", queue.dequeue())
    print("Size after dequeue:", queue.size())
