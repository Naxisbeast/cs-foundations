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

## Phase 2 Time Complexity Tables

### Binary Search — `data-structures/search/`

| Operation | Time Complexity | Space Complexity | Reason |
|---|---|---|---|
| `search` (iterative) | O(log n) | O(1) | Halves the search range each step; no extra memory. |
| `searchRecursive` | O(log n) | O(log n) | Same halving, but each call adds a stack frame. |

### Merge Sort — `data-structures/sorting/`

| Operation | Time Complexity | Space Complexity | Reason |
|---|---|---|---|
| `sort` | O(n log n) all cases | O(n) | Divides into halves (log n levels) and merges each level (n work); the merge allocates two temporary arrays. Stable because the left half is consumed first on equal values. |

### Binary Search Tree — `data-structures/tree/`

| Operation | Time Complexity | Space Complexity | Reason |
|---|---|---|---|
| `insert` | O(log n) average, O(n) worst | O(log n) average | Balanced trees halve the search each level; a skewed tree degrades to a linked list. |
| `contains` | O(log n) average, O(n) worst | O(log n) average | Same as insert. |
| `min` / `max` | O(log n) average, O(n) worst | O(1) | Follow the leftmost / rightmost path. |
| `inOrder` | O(n) | O(n) | Visits every node; stores the result list. |
| `height` | O(n) | O(log n) average | Visits every node on the recursion stack. |

### HashMap (separate chaining) — `data-structures/hash/`

| Operation | Time Complexity | Space Complexity | Reason |
|---|---|---|---|
| `put` | O(1) average, O(n) worst | O(1) per entry | A good hash spreads keys evenly; one bucket can degrade to a linked list. |
| `get` | O(1) average, O(n) worst | O(1) | Same reasoning as put. |
| `remove` | O(1) average, O(n) worst | O(1) | Same reasoning as put. |

## Space Complexity

Time complexity answers "how much faster does it get with more input?". Space complexity answers "how much extra memory does it use with more input?".

- **O(1) constant** — the algorithm needs a fixed amount of extra memory regardless of input size. In-place array operations, the iterative stack/queue, and iterative binary search all qualify.
- **O(n) linear** — extra memory grows with the input. The array stack and queue themselves use O(n) to store their values; merge sort needs O(n) for its merge buffers; a hash map uses O(capacity + entries).
- **O(log n) logarithmic** — extra memory grows slowly. The recursion stack of binary search, and the height of a balanced BST, are both O(log n).
- **O(2^n) / O(n!)** — the classic recursive fibonacci is O(2^n) time and O(n) stack depth; permutations are O(n!) time.

When asked about a structure in an interview, give both numbers: *"insert is O(log n) time and O(log n) space for a balanced tree"*.
