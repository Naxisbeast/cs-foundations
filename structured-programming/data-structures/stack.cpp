// A simple fixed-capacity stack.
//
// This is the C++ mirror of the Java StackUsingArray in
// data-structures/stack/. Same LIFO behaviour and the same empty/full
// handling, translated into C++.
//
// Operations and time complexity:
//   push(value)  O(1)
//   pop()        O(1)
//   peek()       O(1)
//   isEmpty()    O(1)
//   isFull()     O(1)
//   size()       O(1)

#include <iostream>

using namespace std;

const int MAX_CAPACITY = 100;

class Stack {
private:
    int values[MAX_CAPACITY];
    int capacity;
    int topIndex;

public:
    Stack(int capacity) {
        this->capacity = capacity;
        topIndex = -1;
    }

    void push(int value) {
        if (isFull()) {
            cout << "The stack is full. I cannot push " << value << "." << endl;
            return;
        }
        topIndex++;
        values[topIndex] = value;
    }

    int pop() {
        if (isEmpty()) {
            cout << "The stack is empty. There is no value to pop." << endl;
            return -1; // sentinel, mirrors the Java version's null
        }
        return values[topIndex--];
    }

    int peek() {
        if (isEmpty()) {
            cout << "The stack is empty. There is no top value." << endl;
            return -1;
        }
        return values[topIndex];
    }

    bool isEmpty() {
        return topIndex == -1;
    }

    bool isFull() {
        return topIndex == capacity - 1;
    }

    int size() {
        return topIndex + 1;
    }

    void printStack() {
        if (isEmpty()) {
            cout << "Stack: empty" << endl;
            return;
        }
        cout << "Stack bottom -> top: ";
        for (int index = 0; index <= topIndex; index++) {
            cout << values[index];
            if (index < topIndex) {
                cout << ", ";
            }
        }
        cout << endl;
    }
};

int main() {
    Stack stack(3);
    stack.pop();      // empty pop
    stack.push(5);
    stack.push(10);
    stack.push(15);
    stack.push(20);   // capacity reached: dropped
    stack.printStack();
    cout << "Top value: " << stack.peek() << endl;
    cout << "Popped value: " << stack.pop() << endl;
    stack.printStack();
    cout << "Current size: " << stack.size() << endl;
    return 0;
}
