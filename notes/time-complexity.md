# Time Complexity Notes

## What Is Big O?

Big O notation is a way to describe how an algorithm grows as the input size grows.

It does not usually measure exact seconds. Instead, it describes the pattern of growth. For example, an operation that checks one item is very different from an operation that may need to check every item in a list.

## Common Big O Examples

| Big O | Meaning | Simple Example |
|---|---|---|
| O(1) | Constant time | Accessing the top of a stack |
| O(n) | Linear time | Searching through a linked list |
| O(n²) | Quadratic time | Comparing every item with every other item |

## Best, Average, And Worst Case

- Best case: the easiest possible input.
- Average case: a normal or expected input.
- Worst case: the hardest input the algorithm may need to handle.

For example, when searching for a value in a list:

- Best case: the value is the first item.
- Average case: the value is somewhere in the middle.
- Worst case: the value is last or not in the list.

## Phase 1 Time Complexity Tables

### Singly Linked List

| Operation | Time Complexity | Reason |
|---|---|---|
| `addFirst` | O(1) | The new node becomes the head immediately. |
| `addLast` | O(n) | I must move through the list to find the last node. |
| `removeFirst` | O(1) | The head reference moves to the next node. |
| `contains` | O(n) | I may need to check every node. |
| `size` | O(1) | The list keeps a size counter. |
| `isEmpty` | O(1) | It only checks whether the size is zero. |
| `printList` | O(n) | It visits every node. |

### Stack Using Array

| Operation | Time Complexity | Reason |
|---|---|---|
| `push` | O(1) | The value is placed at the next top position. |
| `pop` | O(1) | The top value is removed directly. |
| `peek` | O(1) | The top value is read directly. |
| `isEmpty` | O(1) | It checks the size. |
| `isFull` | O(1) | It compares size with capacity. |
| `printStack` | O(n) | It prints each stored value. |

### Queue Using Array

| Operation | Time Complexity | Reason |
|---|---|---|
| `enqueue` | O(1) | The value is added at the rear position. |
| `dequeue` | O(1) | The front value is removed directly. |
| `peek` | O(1) | The front value is read directly. |
| `isEmpty` | O(1) | It checks the size. |
| `isFull` | O(1) | It compares size with capacity. |
| `printQueue` | O(n) | It prints each stored value. |

### Recursion Examples

| Method | Time Complexity | Reason |
|---|---|---|
| `factorial` | O(n) | It makes one recursive call for each number down to 1. |
| `fibonacci` | O(2^n) | The simple version repeats many calculations. |
| `sumArray` | O(n) | It visits each array element once. |
| `countdown` | O(n) | It prints each number down to 0. |
