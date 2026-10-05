// Real tests for the C++ stack and queue.
//
// STACK_TEST_MODE / QUEUE_TEST_MODE suppress each file's demo main() so
// the class can be #included and tested directly. Run via:
//   g++ -std=c++17 -Wall -Wextra structured-programming/tests/stack_queue_test.cpp -o mini_test && ./mini_test

#define STACK_TEST_MODE
#include "../data-structures/stack.cpp"

#define QUEUE_TEST_MODE
#include "../data-structures/queue.cpp"

#include "mini_test.hpp"

int main() {
    // Stack
    Stack stack(3);
    CHECK(stack.isEmpty());
    CHECK(stack.size() == 0);

    stack.push(5);
    stack.push(10);
    stack.push(15);
    CHECK(stack.size() == 3);
    CHECK(stack.isFull());

    stack.push(20);            // full: dropped
    CHECK(stack.size() == 3);  // capacity still holds

    CHECK(stack.peek() == 15);
    CHECK(stack.pop() == 15);
    CHECK(stack.pop() == 10);
    CHECK(stack.pop() == 5);
    CHECK(stack.isEmpty());

    // Queue
    Queue queue(3);
    CHECK(queue.isEmpty());

    queue.enqueue(100);
    queue.enqueue(200);
    queue.enqueue(300);
    CHECK(queue.getSize() == 3);

    queue.enqueue(400);        // full: dropped
    CHECK(queue.getSize() == 3);

    CHECK(queue.peek() == 100);
    CHECK(queue.dequeue() == 100);

    queue.enqueue(400);        // wraps around into the freed slot
    CHECK(queue.peek() == 200);
    CHECK(queue.dequeue() == 200);
    CHECK(queue.dequeue() == 300);
    CHECK(queue.dequeue() == 400);
    CHECK(queue.isEmpty());

    return miniTestSummary();
}
