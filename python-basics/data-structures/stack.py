"""A simple stack backed by a Python list.

This is the Python mirror of the Java StackUsingArray in
data-structures/stack/. Same LIFO behaviour, idiomatic Python.

Operations and time complexity:
  push(element)  O(1) amortised
  pop()          O(1)
  peek()         O(1)
  is_empty()     O(1)
  size()         O(1)

Design note: the Java version is a fixed-capacity array that prints a
message when full; Python lists grow automatically, so a full stack
cannot happen and empty pop/peek raise IndexError instead of returning
null.
"""


class Stack:
    def __init__(self):
        self._items = []

    def push(self, element):
        self._items.append(element)

    def pop(self):
        if self.is_empty():
            raise IndexError("pop from an empty stack")
        return self._items.pop()

    def peek(self):
        if self.is_empty():
            raise IndexError("peek on an empty stack")
        return self._items[-1]

    def is_empty(self):
        return len(self._items) == 0

    def size(self):
        return len(self._items)

    def __str__(self):
        return f"Stack bottom -> top: {self._items}"


if __name__ == "__main__":
    stack = Stack()
    stack.push(5)
    stack.push(10)
    stack.push(15)
    print(stack)
    print("Top value:", stack.peek())
    print("Popped value:", stack.pop())
    print("Size after pop:", stack.size())
