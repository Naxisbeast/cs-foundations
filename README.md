# cs-foundations

I kept noticing the same ideas repeat across every language I learned — a stack is a stack whether it's Python, Java, or C++. This repo is that observation, made concrete.

It collects the foundation work I did across Python, Java, and C++ into one place, organised by concept rather than by course or language, so the pattern shows instead of the syllabus.

## What's Inside

### Data Structures — Java
- **Linked list** — `data-structures/linked-list/`
- **Stack** (array-based) — `data-structures/stack/`
- **Queue** (array-based) — `data-structures/queue/`
- **Recursion** — `data-structures/recursion/`

These are clean implementations with edge-case handling (empty structures, full arrays) and a demo runner in `src/examples/`.

### Object-Oriented Programming — Java
- **Classes & objects** — `oop-principles/classes-objects/`
- **Encapsulation** — `oop-principles/encapsulation/`
- **Inheritance** — `oop-principles/inheritance/`
- **Polymorphism** — `oop-principles/polymorphism/`
- **Abstraction** — `oop-principles/abstraction/`
- **Interfaces** — `oop-principles/interfaces/`

Each principle has a small worked example plus a test file showing it in use.

### Structured Programming — C++
- **Input/output** — `structured-programming/input-output/`
- **Conditionals** — `structured-programming/conditionals/`
- **Loops** — `structured-programming/loops/`
- **Functions** — `structured-programming/functions/`
- **Arrays** — `structured-programming/arrays/`
- **Structs** — `structured-programming/structs/`
- **Mini project** (library menu system) — `structured-programming/mini-projects/`

This was my procedural programming foundation before moving into OOP and DSA.

### Python Basics — Python
- **Variables & input** — `python-basics/variables-input/`
- **Conditionals** — `python-basics/conditionals/`
- **Loops** — `python-basics/loops/`
- **Functions** — `python-basics/functions/`
- **Lists** — `python-basics/lists/`
- **Files** — `python-basics/files/`
- **Mini project** (simple banking menu) — `python-basics/mini-projects/`

### Academic Assignments — Java
The `academic-assignments/` folder holds selected past CMPG221 exercises, summarised in my own words. These are cleaned summaries, not a raw coursework dump — no student numbers, private screenshots, or original instruction PDFs.

- Assignment 1: OOP inheritance and polymorphism
- Assignment 2: OOP arrays, sorting, and complexity
- Assignment 3: Text-based Snake with `MyArrayList`
- Assignment 4: Music festival booking with `MyLinkedList`
- Assignment 5: Hospital emergency room with linked-list stack and queue
- Assignment 6: Recursion, stack tracing, and string permutations
- Assignment 7: Hybrid sorting algorithm

### Notes
- `notes/time-complexity.md` — Big O, best/average/worst cases, complexity of the core structures
- `notes/oop-principles.md` — the four pillars with concrete Java examples
- `notes/structured-programming.md` and `notes/problem-solving-in-cpp.md` — C++ fundamentals
- `notes/programming-basics.md` and `notes/problem-solving.md` — Python fundamentals

## Why Consolidate

These examples originally lived in separate repos, one per language. Putting them together makes the point explicit: the concepts transfer, the syntax doesn't. A reviewer can see the stack pattern in Java and the same step-by-step problem-solving approach repeated in the C++ and Python examples, side by side.

## How To Run

The Java demo compiles the four data-structure files together; the C++ and Python examples are per-folder and self-contained.

Java (run from the repo root):
```bash
javac -d out data-structures/linked-list/SinglyLinkedList.java data-structures/stack/StackUsingArray.java data-structures/queue/QueueUsingArray.java data-structures/recursion/RecursionExamples.java src/examples/Main.java
java -cp out examples.Main
```

C++:
```bash
g++ structured-programming/mini-projects/library_menu_system.cpp -o library_menu
./library_menu
```

Python:
```bash
python python-basics/mini-projects/simple_banking_menu.py
```

Each folder has its own README with the specific compile/run command and what the example demonstrates.

## Portfolio Note

These examples originally lived in four separate single-language repositories. This repo is their consolidated, concept-organised successor — the point is that the concepts transfer across languages, not that each language needs its own repo.
