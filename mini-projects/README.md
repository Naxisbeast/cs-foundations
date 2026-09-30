# Mini Projects

Small programs that put the structures from this repo to work. Each one is small enough to demo in an interview but exercises a real idea from `data-structures/` or `python-basics/data-structures/`.

## Java — `src/mini-projects/`

| Project | What it demonstrates |
|---|---|
| `Minesweeper.java` | Flood-fill reveal is **BFS in disguise** — the graph traversal from `data-structures/graph/`, hiding inside a game. |
| `TodoList.java` | A hand-rolled linked list with add / remove / toggle-done; the O(n) `addLast` cost in practice. |

## Python — `python-basics/mini-projects/`

| Project | What it demonstrates |
|---|---|
| `expense_tracker.py` | Dict aggregation and ranking — the hash-map idea in action. |
| `hangman.py` | Sets, string rendering, and a game loop, all in CS vocabulary. |
| `word_frequency.py` | Counting words with a dict and ranking into a top-N list. |

## C++ — `structured-programming/mini-projects/`

| Project | What it demonstrates |
|---|---|
| `inventory_system.cpp` | Structs, arrays, linear search, and filtering into a report. |
| `guessing_game.cpp` | Loops, conditionals, functions, and `cin` validation with session stats. |

## Run

- **Java** (Minesweeper): `javac -d out src/mini-projects/Minesweeper.java && java -cp out mini_projects.Minesweeper`
- **Python** (Hangman): `python python-basics/mini-projects/hangman.py`
- **C++** (Inventory): `g++ structured-programming/mini-projects/inventory_system.cpp -o inventory && ./inventory`
