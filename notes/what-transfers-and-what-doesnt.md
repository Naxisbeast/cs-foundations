# What Transfers Between Languages, And What Doesn't

The whole point of this repo is that a stack is a stack in any language. Here's the honest version of that claim, from implementing the same two structures in Java, Python, and C++.

## The stack, three times

| | Java — `StackUsingArray` | Python — `stack.py` | C++ — `stack.cpp` |
|---|---|---|---|
| Storage | Fixed-size array | Growable list | Fixed-size array |
| Push | `push(value)` — O(1) | `push(element)` — O(1) | `push(value)` — O(1) |
| Pop | `Integer pop()` | `pop()` | `int pop()` |
| Empty pop | Returns `null` + prints | Raises `IndexError` | Returns `-1` sentinel |
| Full push | Prints + drops | Impossible (grows) | Prints + drops |

## What transferred exactly

- **The semantics.** LIFO, O(1) push and pop, `peek` that does not remove — identical in all three. I copied the operations from the Java version into the others without thinking about them.
- **The edge cases you must handle.** "What happens on empty?" and "what happens at capacity?" are the same questions in every language; only the answers differ.

## What didn't — and what each language forced me to notice

- **Empty pop is a design decision, and each language chose differently.** Java returns `null` — which is why `pop()` has to return `Integer` instead of `int`, a small type-level cost of using null as a signal. Python raises `IndexError`, which is honestly cleaner: callers cannot silently ignore a bad pop. C++ returns a `-1` sentinel, which is the pragmatic C++ answer but means `-1` is not a valid stack value.

  This is the single most instructive difference in the whole comparison. The algorithm is identical; the "empty case" is where the language's culture shows up.

- **Memory ownership is invisible until you write C++.** In Java and Python the array slot is garbage-collected when the stack shrinks; nobody thinks about it. In C++, `pop()` just decrements an index and the old value stays in the array until overwritten — nothing is "freed" because nothing was allocated on the heap. The Java question "does popping free the element?" simply does not exist in the same form.

- **Capacity is a compile-time decision in C++.** `int values[MAX_CAPACITY]` fixes the size at compile time, so a capacity-per-instance constructor means a fixed upper bound of 100. Java's `new int[capacity]` is per-instance. Python's list grows. Same algorithm, three different relationships to "how big is it."

- **Python made the happy path shortest.** No capacity check, no null, no sentinel — push is one line and pop raises on misuse. It reads cleanest because the language took the "handle it in the caller" approach.

## Which I'd reach for in production

- **Stack:** Python's built-in `list` (same operations, native). C++: `std::stack`. Java: `ArrayDeque`. Nobody writes these by hand in production — the value of the hand-written versions is *knowing what's inside the standard library one*.
- **Queue:** `collections.deque` in Python (O(1) both ends — a plain list can't do O(1) front-pop), `std::queue` in C++, `ArrayDeque` in Java.

## The one-sentence takeaway

The operations and the complexity transfer perfectly; the *edge cases* and the *ownership model* don't. If an interviewer asks what the language comparison taught you, that's the answer.
