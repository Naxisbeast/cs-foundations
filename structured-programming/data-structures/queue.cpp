// A simple fixed-capacity circular queue.
//
// This is the C++ mirror of the Java QueueUsingArray in
// data-structures/queue/. Same FIFO behaviour, including the circular
// buffer that reuses freed slots.
//
// Operations and time complexity:
//   enqueue(value)  O(1)
//   dequeue()       O(1)
//   peek()          O(1)
//   isEmpty()       O(1)
//   isFull()        O(1)
//   size()          O(1)

#include <iostream>

using namespace std;

const int MAX_CAPACITY = 100;

class Queue {
private:
    int values[MAX_CAPACITY];
    int capacity;
    int frontIndex;
    int rearIndex;
    int size;

public:
    Queue(int capacity) {
        this->capacity = capacity;
        frontIndex = 0;
        rearIndex = -1;
        size = 0;
    }

    void enqueue(int value) {
        if (isFull()) {
            cout << "The queue is full. I cannot enqueue " << value << "." << endl;
            return;
        }
        rearIndex = (rearIndex + 1) % capacity;
        values[rearIndex] = value;
        size++;
    }

    int dequeue() {
        if (isEmpty()) {
            cout << "The queue is empty. There is no value to dequeue." << endl;
            return -1; // sentinel, mirrors the Java version's null
        }
        int removedValue = values[frontIndex];
        frontIndex = (frontIndex + 1) % capacity;
        size--;
        return removedValue;
    }

    int peek() {
        if (isEmpty()) {
            cout << "The queue is empty. There is no front value." << endl;
            return -1;
        }
        return values[frontIndex];
    }

    bool isEmpty() {
        return size == 0;
    }

    bool isFull() {
        return size == capacity;
    }

    int getSize() {
        return size;
    }

    void printQueue() {
        if (isEmpty()) {
            cout << "Queue: empty" << endl;
            return;
        }
        cout << "Queue front -> rear: ";
        for (int index = 0; index < size; index++) {
            int circularIndex = (frontIndex + index) % capacity;
            cout << values[circularIndex];
            if (index < size - 1) {
                cout << ", ";
            }
        }
        cout << endl;
    }
};

int main() {
    Queue queue(3);
    queue.dequeue();   // empty dequeue
    queue.enqueue(100);
    queue.enqueue(200);
    queue.enqueue(300);
    queue.enqueue(400); // capacity reached: dropped
    queue.printQueue();
    cout << "Front value: " << queue.peek() << endl;
    cout << "Dequeued value: " << queue.dequeue() << endl;
    queue.enqueue(400); // wraps around into the freed slot
    queue.printQueue();
    cout << "Current size: " << queue.getSize() << endl;
    return 0;
}
