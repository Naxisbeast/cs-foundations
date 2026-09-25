import java.util.Arrays;
import java.util.Random;

import sorting.MergeSort;

/**
 * Empirical timing for a few complexity claims made in notes/time-complexity.md.
 *
 * Run:  javac -d out data-structures/sorting/MergeSort.java benchmarks/Benchmark.java
 *       java -cp out Benchmark
 *
 * Results captured in benchmarks/RESULTS.md. These numbers are illustrative,
 * not rigorous — JIT warm-up and machine load vary — but they show the shape:
 * O(2^n) fibonacci collapses next to O(n), and a fixed-capacity merge sort
 * trails the JIT-tuned JDK sort.
 */
public final class Benchmark {

    public static void main(String[] args) {
        System.out.println("=== Complexity Benchmarks ===\n");
        benchmarkFibonacci();
        benchmarkSorting();
    }

    static int fibRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    static int fibMemoized(int n) {
        return fibMemoized(n, new int[n + 1]);
    }

    private static int fibMemoized(int n, int[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibMemoized(n - 1, memo) + fibMemoized(n - 2, memo);
        return memo[n];
    }

    private static void benchmarkFibonacci() {
        int n = 40;
        System.out.println("Fibonacci(" + n + ") - O(2^n) recursive vs O(n) memoized:");

        long start = System.nanoTime();
        int recursiveResult = fibRecursive(n);
        long recursiveMs = (System.nanoTime() - start) / 1_000_000;

        start = System.nanoTime();
        int memoizedResult = fibMemoized(n);
        long memoizedMs = (System.nanoTime() - start) / 1_000_000;

        System.out.printf("  recursive:  %d  in %5d ms%n", recursiveResult, recursiveMs);
        System.out.printf("  memoized:   %d  in %5d ms%n", memoizedResult, memoizedMs);
        System.out.printf("  speedup:    %.0fx%n%n", (double) recursiveMs / Math.max(memoizedMs, 1));
    }

    private static void benchmarkSorting() {
        int n = 100_000;
        System.out.println("Sorting " + n + " elements - repo MergeSort vs JDK Arrays.sort:");

        for (String label : new String[]{"random", "sorted", "reverse"}) {
            int[] data = switch (label) {
                case "random" -> randomArray(n);
                case "sorted" -> sortedArray(n);
                default -> reverseArray(n);
            };

            int[] copy = data.clone();
            long start = System.nanoTime();
            MergeSort.sort(copy);
            long mergeMs = (System.nanoTime() - start) / 1_000_000;

            start = System.nanoTime();
            Arrays.sort(data);
            long jdkMs = (System.nanoTime() - start) / 1_000_000;

            System.out.printf("  %-7s mergeSort %6d ms   Arrays.sort %6d ms%n",
                    label, mergeMs, jdkMs);
        }
    }

    private static int[] randomArray(int n) {
        Random random = new Random(42);
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = random.nextInt(n);
        }
        return values;
    }

    private static int[] sortedArray(int n) {
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = i;
        }
        return values;
    }

    private static int[] reverseArray(int n) {
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = n - i;
        }
        return values;
    }
}
