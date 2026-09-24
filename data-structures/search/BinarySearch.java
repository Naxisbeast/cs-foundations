package search;

/**
 * Binary search over a sorted array. Returns the index of the value, or -1
 * if it is not present.
 *
 * Time complexity: O(log n) for both versions.
 * Space complexity: O(1) iterative, O(log n) for the recursive call stack.
 *
 * The mid point is computed as {@code low + (high - low) / 2} instead of
 * {@code (low + high) / 2} so very large arrays cannot overflow the int sum.
 */
public final class BinarySearch {

    private BinarySearch() {
        // utility class
    }

    public static int search(int[] numbers, int value) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] == value) {
                return mid;
            }
            if (numbers[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int searchRecursive(int[] numbers, int value) {
        return searchRecursive(numbers, value, 0, numbers.length - 1);
    }

    private static int searchRecursive(int[] numbers, int value, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (numbers[mid] == value) {
            return mid;
        }
        if (numbers[mid] < value) {
            return searchRecursive(numbers, value, mid + 1, high);
        }
        return searchRecursive(numbers, value, low, mid - 1);
    }
}
