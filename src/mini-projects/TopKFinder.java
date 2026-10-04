package mini_projects;

import java.util.Arrays;
import java.util.Random;

import heap.MinHeap;

/**
 * Top-K over a large dataset, using a min-heap of size K.
 *
 * The trick: keep a min-heap of the K best values seen so far. When a new
 * value is bigger than the heap's smallest, evict that smallest and insert
 * the new one. The heap stays size K the whole way, so this is O(n log k)
 * instead of the O(n log n) of sorting the whole dataset first.
 *
 * This is the same idea behind real-world top-K over a big CSV or log file:
 * you never hold more than K rows in memory.
 */
public class TopKFinder {

    /** The K largest values, ascending. */
    public static int[] topK(int[] values, int k) {
        if (k < 0) {
            throw new IllegalArgumentException("k cannot be negative.");
        }
        if (k == 0) {
            return new int[0];
        }

        MinHeap heap = new MinHeap();
        for (int value : values) {
            if (heap.size() < k) {
                heap.insert(value);
            } else if (value > heap.peek()) {
                heap.extractMin();
                heap.insert(value);
            }
        }

        int[] result = new int[heap.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = heap.extractMin();   // ascending: smallest of the top-K first
        }
        return result;
    }

    /** Brute-force reference: sort the whole array and take the tail. */
    public static int[] topKSorted(int[] values, int k) {
        int[] copy = values.clone();
        Arrays.sort(copy);
        return Arrays.copyOfRange(copy, copy.length - k, copy.length);
    }

    public static void main(String[] args) {
        Random random = new Random(7);
        int n = 1_000_000;
        int k = 10;
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(1_000_000);
        }

        long start = System.nanoTime();
        int[] top = topK(data, k);
        long heapMs = (System.nanoTime() - start) / 1_000_000;

        start = System.nanoTime();
        int[] reference = topKSorted(data, k);
        long sortMs = (System.nanoTime() - start) / 1_000_000;

        System.out.println("Top " + k + " of " + n + " values:");
        System.out.println("  heap-based (O(n log k)): " + Arrays.toString(top) + "  " + heapMs + " ms");
        System.out.println("  full sort (O(n log n)):  " + Arrays.toString(reference) + "  " + sortMs + " ms");
        System.out.println("  match: " + Arrays.equals(top, reference));
    }
}
