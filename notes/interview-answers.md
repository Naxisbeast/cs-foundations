# Interview Answers — This Repo's Story

The questions a reviewer will ask, and the honest answers, written down so they are ready before the interview rather than fumbled in the room.

## 1. What's the hardest bug you hit, and how did you find it?

The booking system in assignment 4. Cancelling a booking removed the attendee from the linked list but never decremented the event's attendee count, so the "fully booked" check and the seat numbers went permanently stale after the first cancellation. I found it by writing a book → cancel → display flow and watching the "Total" stay the same when it should have dropped. The fix made the event own its count — `addAttendee` / `removeAttendee` keep it in sync, so it can't drift again.

## 2. Which implementation would you change if you redid it, and why?

The original BookingSystem's way of searching. It converted the whole linked list to a string and parsed the output with `substring` and `split` to find an event or attendee. It worked, but any change to `toString` would silently break it. I rewrote it to traverse the list with `findFirst` / `removeFirstMatch` — the same information, no parsing. Second candidate: the array queue prints a message and drops a value when full, where Python and C++ handle the same case by raising or returning a sentinel. I'd make the Java empty/full behaviour consistent with the others.

## 3. Why array-based rather than linked for your queue, and what breaks at scale?

The array (circular) queue is O(1) enqueue and O(1) dequeue with a fixed capacity; the linked version has O(1) dequeue but O(n) enqueue because it walks to the tail. At scale, the linked queue's enqueue degrades linearly. What actually breaks: the array queue has a hard ceiling — a full queue drops data (with a message). The linked queue never drops, but enqueue becomes the bottleneck. If I redid it, I'd add a tail pointer to the linked version for O(1) enqueue — the `MyLinkedList` in the assignments already keeps one.

## 4. What did the language comparison teach you?

The operations and the complexity transfer perfectly — I copied push and pop between Java, Python and C++ without thinking. What doesn't transfer is the edge cases and the ownership model: empty pop returns `null` in Java, raises in Python, and returns a sentinel in C++ — and "freeing" a popped slot only makes sense where memory is manually managed. That's the real lesson: the algorithm is the same; the design decisions around it are where each language shows its culture.
