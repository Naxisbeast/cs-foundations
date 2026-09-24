# Python Basics

Beginner Python: variables, conditionals, loops, functions, lists, files, and a mini project — the same procedural ideas as the C++ section, in Python.

| Folder | Topic |
|---|---|
| `variables-input/` | Input/output, type conversion, safe defaults |
| `conditionals/` | Grade checker with input validation |
| `loops/` | `for`/`while` loops and a triangle pattern |
| `functions/` | Calculator functions, guarded division |
| `lists/` | Student marks analyzer |
| `files/` | Word counter with proper file handling |
| `mini-projects/` | Simple banking menu |
| `data-structures/` | Stack and queue — the Python mirrors of the Java structures in `data-structures/` |

## Run

Each file is self-contained and runs directly. The data-structures examples:

```bash
python python-basics/data-structures/stack.py
python python-basics/data-structures/queue.py
```

## Notes

- File handling uses a `with` context manager and handles a missing file gracefully.
- `data-structures/` mirrors the Java stack and queue using idiomatic Python — a growable list for the stack and `collections.deque` for the queue. Each docstring explains the contrast and the per-operation time complexity.
- Theory: [`notes/programming-basics.md`](../notes/programming-basics.md) and [`notes/problem-solving.md`](../notes/problem-solving.md).
