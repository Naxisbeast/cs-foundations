public class HybridSort {

    static int comparisons = 0;
    static int swaps = 0;
    static final int THRESHOLD = 10; // switch to insertion sort below this size

    public static void main(String[] args) {
        int[] arr = {34, 7, 23, 32, 5, 62, 15, 1, 90, 45, 12, 3, 57, 100, 78, 93, 11, 56, 78, 0, 5, 36};
        int n = arr.length;

        System.out.println("Original Array:");
        printArray(arr);

        hybridQuickSort(arr, 0, n - 1);

        System.out.println("\nSorted Array:");
        printArray(arr);

        System.out.println("\nTotal Comparisons: " + comparisons);
        System.out.println("Total Swaps: " + swaps);
        System.out.println("\nAsymptotic Analysis:");
        System.out.println("Best Case: O(n log n)");
        System.out.println("Average Case: O(n log n)");
        System.out.println("Worst Case: O(n^2)");
    }

    // Hybrid Quick Sort
    static void hybridQuickSort(int[] arr, int low, int high) {
        while (low < high) {
            if (high - low + 1 < THRESHOLD) {
                insertionSort(arr, low, high);
                break;
            } else {
                int pivot = partition(arr, low, high);
                if (pivot - low < high - pivot) {
                    hybridQuickSort(arr, low, pivot - 1);
                    low = pivot + 1;
                } else {
                    hybridQuickSort(arr, pivot + 1, high);
                    high = pivot - 1;
                }
            }
        }
    }

    // Partition function for Quick Sort
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    // Insertion Sort for small subarrays
    static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                swaps++;
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Swap helper
    static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            swaps++;
        }
    }

    // Print helper
    static void printArray(int[] arr) {
        for (int n : arr) System.out.print(n + " ");
        System.out.println();
    }
}
