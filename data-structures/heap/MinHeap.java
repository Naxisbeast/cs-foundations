package heap;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary min-heap backed by a dynamic array.
 *
 * The heap property: every node is smaller than or equal to its children,
 * so the smallest value is always at index 0.
 *
 * Time complexity:
 *   insert      O(log n)
 *   extractMin  O(log n)
 *   peek        O(1)
 *   size        O(1)
 * Space complexity: O(n) for the array itself.
 *
 * Used as the basis for a priority queue and for heap sort / top-K problems.
 */
public class MinHeap {

    private final List<Integer> values = new ArrayList<>();

    /** Insert a value and restore the heap property by sifting up. */
    public void insert(int value) {
        values.add(value);
        siftUp(values.size() - 1);
    }

    /** Return the smallest value without removing it. */
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek an empty heap.");
        }
        return values.get(0);
    }

    /** Remove and return the smallest value, restoring the heap property. */
    public int extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot extract from an empty heap.");
        }
        int min = values.get(0);
        int last = values.remove(values.size() - 1);
        if (!values.isEmpty()) {
            values.set(0, last);
            siftDown(0);
        }
        return min;
    }

    public int size() {
        return values.size();
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (values.get(parent) <= values.get(index)) {
                break;
            }
            swap(index, parent);
            index = parent;
        }
    }

    private void siftDown(int index) {
        int size = values.size();
        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallest = index;

            if (left < size && values.get(left) < values.get(smallest)) {
                smallest = left;
            }
            if (right < size && values.get(right) < values.get(smallest)) {
                smallest = right;
            }
            if (smallest == index) {
                break;
            }
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int a, int b) {
        int temp = values.get(a);
        values.set(a, values.get(b));
        values.set(b, temp);
    }
}
