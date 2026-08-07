package examples;

import linkedlists.SinglyLinkedList;
import queues.QueueUsingArray;
import recursion.RecursionExamples;
import stacks.StackUsingArray;

public class Main {
    public static void main(String[] args) {
        demonstrateSinglyLinkedList();
        demonstrateStackUsingArray();
        demonstrateQueueUsingArray();
        demonstrateRecursionExamples();
    }

    private static void demonstrateSinglyLinkedList() {
        System.out.println("=== Singly Linked List ===");

        SinglyLinkedList list = new SinglyLinkedList();
        list.printList();
        System.out.println("Contains 10 before adding values: " + list.contains(10));

        list.addFirst(20);
        list.addFirst(10);
        list.addLast(30);
        list.printList();

        System.out.println("Contains 20: " + list.contains(20));
        System.out.println("Removed first value: " + list.removeFirst());
        list.printList();
        System.out.println("Current size: " + list.size());
        System.out.println();
    }

    private static void demonstrateStackUsingArray() {
        System.out.println("=== Stack Using Array ===");

        StackUsingArray stack = new StackUsingArray(3);
        stack.pop();

        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.printStack();

        System.out.println("Top value: " + stack.peek());
        System.out.println("Popped value: " + stack.pop());
        stack.printStack();
        System.out.println("Current size: " + stack.size());
        System.out.println();
    }

    private static void demonstrateQueueUsingArray() {
        System.out.println("=== Queue Using Array ===");

        QueueUsingArray queue = new QueueUsingArray(3);
        queue.dequeue();

        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);
        queue.printQueue();

        System.out.println("Front value: " + queue.peek());
        System.out.println("Dequeued value: " + queue.dequeue());
        queue.enqueue(400);
        queue.printQueue();
        System.out.println("Current size: " + queue.size());
        System.out.println();
    }

    private static void demonstrateRecursionExamples() {
        System.out.println("=== Recursion Examples ===");

        int[] numbers = {2, 4, 6, 8};
        int[] emptyNumbers = {};

        System.out.println("Factorial of 5: " + RecursionExamples.factorial(5));
        System.out.println("Fibonacci of 6: " + RecursionExamples.fibonacci(6));
        System.out.println("Sum of array: " + RecursionExamples.sumArray(numbers, 0));
        System.out.println("Sum of empty array: " + RecursionExamples.sumArray(emptyNumbers, 0));

        System.out.println("Countdown from 3:");
        RecursionExamples.countdown(3);
    }
}
