import java.util.Arrays;
import java.util.Random;

/**
 * A mini-study of the hybrid sort from academic-assignments/assignment-07.
 *
 * Assignment 7 combined quicksort with an insertion-sort cutoff of 10.
 * This benchmark asks the question that assignment never did: is 10 the
 * right crossover point, and where does plain quicksort actually lose to
 * insertion sort?
 *
 * Run:  javac -d out benchmarks/SortCrossover.java && java -cp out SortCrossover
 *
 * The hybrid is parametrised by threshold so it can be swept. Timing is
 * illustrative, not rigorous - the shape is what matters.
 */
public final class SortCrossover {

    private static final Random RANDOM = new Random(42);

    public static void main(String[] args) {
        System.out.println("=== Hybrid sort crossover study ===\n");

        int[] sizes = {100, 1_000, 5_000, 10_000, 50_000};

        System.out.println("Time by size (random data, ms):");
        System.out.printf("%-9s %-12s %-12s %-12s%n", "n", "insertion", "quick(0)", "hybrid(10)");
        for (int n : sizes) {
            int[] data = randomArray(n);
            double insertion = time(() -> insertionSort(data.clone()));
            double plain = time(() -> quicksort(data.clone(), 0));
            double hybrid = time(() -> quicksort(data.clone(), 10));
            System.out.printf("%-9d %-12.2f %-12.2f %-12.2f%n", n, insertion, plain, hybrid);
        }

        System.out.println();
        System.out.println("Threshold sweep at n = 10,000 (random data, ms):");
        System.out.printf("%-12s %-12s%n", "threshold", "hybrid time");
        for (int threshold : new int[]{0, 5, 10, 20, 40, 100}) {
            int[] data = randomArray(10_000);
            double hybrid = time(() -> quicksort(data.clone(), threshold));
            System.out.printf("%-12d %-12.2f%n", threshold, hybrid);
        }

        System.out.println();
        System.out.println("Best / average / worst-case shape (n = 10,000):");
        System.out.printf("%-12s %-12s %-12s%n", "input", "plain quick", "hybrid(10)");
        for (String label : new String[]{"random", "sorted", "reverse"}) {
            int[] data = switch (label) {
                case "random" -> randomArray(10_000);
                case "sorted" -> sortedArray(10_000);
                default -> reverseArray(10_000);
            };
            System.out.printf("%-12s %-12.2f %-12.2f%n", label,
                    time(() -> quicksort(data.clone(), 0)),
                    time(() -> quicksort(data.clone(), 10)));
        }
    }

    /** Quicksort with an insertion-sort cutoff. threshold = 0 is plain quicksort. */
    static void quicksort(int[] values, int threshold) {
        quicksort(values, 0, values.length - 1, threshold);
    }

    private static void quicksort(int[] values, int low, int high, int threshold) {
        if (high - low + 1 < threshold) {
            insertionSort(values, low, high);
            return;
        }
        if (low >= high) {
            return;
        }
        int pivot = partition(values, low, high);
        quicksort(values, low, pivot - 1, threshold);
        quicksort(values, pivot + 1, high, threshold);
    }

    private static int partition(int[] values, int low, int high) {
        int pivot = values[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (values[j] <= pivot) {
                i++;
                int temp = values[i];
                values[i] = values[j];
                values[j] = temp;
            }
        }
        int temp = values[i + 1];
        values[i + 1] = values[high];
        values[high] = temp;
        return i + 1;
    }

    private static void insertionSort(int[] values, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = values[i];
            int j = i - 1;
            while (j >= low && values[j] > key) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = key;
        }
    }

    static void insertionSort(int[] values) {
        insertionSort(values, 0, values.length - 1);
    }

    private static double time(Runnable runnable) {
        long start = System.nanoTime();
        runnable.run();
        return (System.nanoTime() - start) / 1_000_000.0;
    }

    private static int[] randomArray(int n) {
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = RANDOM.nextInt(n);
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
