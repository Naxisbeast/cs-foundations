package queues;

public class QueueUsingArray {
    private final int[] values;
    private int frontIndex;
    private int rearIndex;
    private int size;

    public QueueUsingArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Queue capacity must be greater than zero.");
        }

        values = new int[capacity];
        frontIndex = 0;
        rearIndex = -1;
        size = 0;
    }

    public void enqueue(int value) {
        if (isFull()) {
            System.out.println("The queue is full. I cannot enqueue " + value + ".");
            return;
        }

        rearIndex = (rearIndex + 1) % values.length;
        values[rearIndex] = value;
        size++;
    }

    public Integer dequeue() {
        // I check whether the queue is empty before removing the front value.
        if (isEmpty()) {
            System.out.println("The queue is empty. There is no value to dequeue.");
            return null;
        }

        int removedValue = values[frontIndex];
        frontIndex = (frontIndex + 1) % values.length;
        size--;
        return removedValue;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("The queue is empty. There is no front value.");
            return null;
        }

        return values[frontIndex];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == values.length;
    }

    public int size() {
        return size;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue: empty");
            return;
        }

        System.out.print("Queue front -> rear: ");
        for (int index = 0; index < size; index++) {
            int circularIndex = (frontIndex + index) % values.length;
            System.out.print(values[circularIndex]);
            if (index < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
