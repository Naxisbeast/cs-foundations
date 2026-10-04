# cs-foundations

[![verify](https://github.com/Naxisbeast/cs-foundations/actions/workflows/verify.yml/badge.svg)](https://github.com/Naxisbeast/cs-foundations/actions/workflows/verify.yml)

I kept noticing the same ideas repeat across every language I learned — a stack is a stack whether it's Python, Java, or C++. This repo is that observation, made concrete: the foundation work I did across three languages, organised by concept instead of by syllabus.

## Start Here

- **[Data structures](./data-structures/README.md)** — stack, queue, linked list, binary search, merge sort, BST, heap, hash map, graph. Each with edge-case handling and JUnit tests.
- **[Mini projects](./mini-projects/README.md)** — a Minesweeper whose flood-fill reveal is BFS in disguise, a to-do list on a hand-rolled linked list, an expense tracker, Hangman, and more.
- **[One concept, three languages](./notes/what-transfers-and-what-doesnt.md)** — the same stack and queue in Java, Python, and C++, and what moving between them taught me.
- **[Benchmarks](./benchmarks/RESULTS.md)** — complexity claims tested against a stopwatch, not just asserted.

## What's Inside

### Data Structures — Java · *demonstrates: edge-case handling, O(1)/O(log n) APIs, test-first thinking*

- **Linked list** — `data-structures/linked-list/` (plus a linked-list stack and queue)
- **Stack** (array-based) — `data-structures/stack/`
- **Queue** (array-based) — `data-structures/queue/`
- **Recursion** — `data-structures/recursion/`
- **Binary search** — `data-structures/search/`
- **Merge sort** — `data-structures/sorting/`
- **Binary search tree** — `data-structures/tree/` (insert, delete, three traversals)
- **Min heap** — `data-structures/heap/`
- **Hash map** — `data-structures/hash/` (separate chaining)
- **Graph** — `data-structures/graph/` (BFS + DFS)

Every structure has its own JUnit tests, and the per-operation complexity is documented in [`notes/time-complexity.md`](notes/time-complexity.md).

### Mini Projects — Java, Python, C++ · *demonstrates: applying structures to real programs*

See [`mini-projects/README.md`](mini-projects/README.md) — one page on each project, the structure it exercises, and how to run it.

### Object-Oriented Programming — Java · *demonstrates: the four pillars, one worked example each*

- **Classes & objects** — `oop-principles/classes-objects/`
- **Encapsulation** — `oop-principles/encapsulation/`
- **Inheritance** — `oop-principles/inheritance/`
- **Polymorphism** — `oop-principles/polymorphism/`
- **Abstraction** — `oop-principles/abstraction/`
- **Interfaces** — `oop-principles/interfaces/`

Each principle has a small example and a runner showing it in use; the reasoning lives in [`notes/oop-principles.md`](notes/oop-principles.md).

### The Same Idea In Every Language · *demonstrates: the concepts transfer, the syntax doesn't*

The stack and queue exist in all three languages:

- Java — `data-structures/stack/`, `data-structures/queue/`
- Python — `python-basics/data-structures/`
- C++ — `structured-programming/data-structures/`

[`notes/what-transfers-and-what-doesnt.md`](notes/what-transfers-and-what-doesnt.md) is the honest write-up: what stayed the same, what each language forced me to think about, and which version I'd reach for in production.

### Structured Programming — C++ · *the procedural foundation before OOP*

Input/output, conditionals, loops, functions, arrays, structs, and a library-menu mini project — `structured-programming/`.

### Python Basics — Python · *beginner Python, mirroring the C++ section*

Variables, conditionals, loops, functions, lists, files, and a banking menu — `python-basics/`.

### Academic Assignments — Java · *selected past coursework, cleaned and summarised*

Seven CMPG221 exercises — OOP, arrays + complexity, Snake on `MyArrayList`, a booking system on `MyLinkedList`, an ER with linked-list stack/queue, recursion + permutations, and a hybrid sort — in `academic-assignments/`, each with a short "what I learned" write-up.

## Verification

`bash scripts/verify.sh` compiles every Java folder, runs the JUnit suite, runs the pytest suite, syntax-checks the Python, and compiles the C++ when a compiler is present. GitHub Actions runs it on every push, so the badge above is live.

## Why One Repo

These examples started in four single-language repos. Putting them together is the point: the concepts transfer, the syntax doesn't. One repo shows the pattern instead of four copies of the syllabus.
