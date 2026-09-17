# Data Structures — Java

Clean implementations of the core structures, one per folder. The demo runner in `src/examples/Main.java` exercises them together.

| Folder | Structure | Key operations |
|---|---|---|
| `stack/` | Array-based stack | `push`, `pop`, `peek` — O(1), with empty/full handling |
| `queue/` | Circular array queue | `enqueue`, `dequeue`, `peek` — O(1), reuses freed slots |
| `linked-list/` | Singly linked list | `addFirst` O(1), `addLast` O(n), `removeFirst`, `contains` |
| `recursion/` | Recursive examples | factorial, fibonacci, sumArray, countdown |

## Run

From the repo root:

```bash
javac -d out data-structures/linked-list/SinglyLinkedList.java data-structures/stack/StackUsingArray.java data-structures/queue/QueueUsingArray.java data-structures/recursion/RecursionExamples.java src/examples/Main.java
java -cp out examples.Main
```

## Notes

- Per-operation time complexity for every structure is in [`notes/time-complexity.md`](../notes/time-complexity.md).
- The stack and queue reject invalid capacities in their constructors, and return `null` with a message on empty `pop`/`peek`.
- These are demos with defensive edge-case handling, not an assertion-based test suite — JUnit coverage is a planned addition.
