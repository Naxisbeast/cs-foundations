package sorting;

/**
 * Classic divide-and-conquer merge sort.
 *
 * Time complexity: O(n log n) for best, average, and worst case.
 * Space complexity: O(n) — the merge step allocates two temporary arrays.
 * Stable: equal elements keep their relative order (the left half is
 * consumed first when the values are equal).
 */
public final class MergeSort {

    private MergeSort() {
        // utility class
    }

    public static void sort(int[] values) {
        sort(values, 0, values.length - 1);
    }

    private static void sort(int[] values, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        sort(values, low, mid);
        sort(values, mid + 1, high);
        merge(values, low, mid, high);
    }

    private static void merge(int[] values, int low, int mid, int high) {
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];

        System.arraycopy(values, low, left, 0, left.length);
        System.arraycopy(values, mid + 1, right, 0, right.length);

        int i = 0;
        int j = 0;
        int k = low;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                values[k++] = left[i++];
            } else {
                values[k++] = right[j++];
            }
        }

        while (i < left.length) {
            values[k++] = left[i++];
        }
        while (j < right.length) {
            values[k++] = right[j++];
        }
    }
}
