package stacks;

public class StackUsingArray {
    private final int[] values;
    private int topIndex;

    public StackUsingArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Stack capacity must be greater than zero.");
        }

        values = new int[capacity];
        topIndex = -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("The stack is full. I cannot push " + value + ".");
            return;
        }

        topIndex++;
        values[topIndex] = value;
    }

    public Integer pop() {
        // I check for an empty stack before reading the top value.
        if (isEmpty()) {
            System.out.println("The stack is empty. There is no value to pop.");
            return null;
        }

        int removedValue = values[topIndex];
        topIndex--;
        return removedValue;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("The stack is empty. There is no top value.");
            return null;
        }

        return values[topIndex];
    }

    public boolean isEmpty() {
        return topIndex == -1;
    }

    public boolean isFull() {
        return topIndex == values.length - 1;
    }

    public int size() {
        return topIndex + 1;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack: empty");
            return;
        }

        System.out.print("Stack bottom -> top: ");
        for (int index = 0; index <= topIndex; index++) {
            System.out.print(values[index]);
            if (index < topIndex) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
