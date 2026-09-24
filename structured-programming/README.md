# Structured Programming — C++

My procedural programming foundation: sequence, selection, iteration, and modularity in C++, before moving into OOP and DSA.

| Folder | Topic |
|---|---|
| `input-output/` | Student profile with input validation |
| `conditionals/` | Number classifier (positive / negative / zero, even / odd) |
| `loops/` | Multiplication table using `for` and `while` |
| `functions/` | Calculator split into functions, guarded division |
| `arrays/` | Marks analyzer (average, highest, lowest, pass/fail) |
| `structs/` | Student record system using structs |
| `mini-projects/` | Library menu system — borrow/return with robust input handling |
| `data-structures/` | Stack and queue — fixed-capacity mirrors of the Java structures in `data-structures/` |

## Run

Each file is self-contained. Examples:

```bash
g++ structured-programming/mini-projects/library_menu_system.cpp -o library_menu
./library_menu

g++ structured-programming/data-structures/stack.cpp -o stack_demo
./stack_demo
```

## Notes

- Bad input is recovered from with `cin.fail()` instead of letting the program crash.
- `data-structures/` mirrors the Java stack and queue using fixed-capacity arrays, with the same empty/full handling. Each file documents the per-operation time complexity.
- Theory: [`notes/structured-programming.md`](../notes/structured-programming.md) and [`notes/problem-solving-in-cpp.md`](../notes/problem-solving-in-cpp.md).
