package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void sortEmptyArrayLeavesItEmpty() {
        int[] values = {};
        MergeSort.sort(values);
        assertArrayEquals(new int[]{}, values);
    }

    @Test
    void sortSingleElementIsUnchanged() {
        int[] values = {42};
        MergeSort.sort(values);
        assertArrayEquals(new int[]{42}, values);
    }

    @Test
    void sortUnsortedArray() {
        int[] values = {5, 2, 9, 1, 7, 3};
        MergeSort.sort(values);
        assertArrayEquals(new int[]{1, 2, 3, 5, 7, 9}, values);
    }

    @Test
    void sortAlreadySortedArray() {
        int[] values = {1, 2, 3, 4, 5};
        MergeSort.sort(values);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, values);
    }

    @Test
    void sortReverseSortedArray() {
        int[] values = {5, 4, 3, 2, 1};
        MergeSort.sort(values);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, values);
    }

    @Test
    void sortArrayWithDuplicatesIsStable() {
        int[] values = {3, 1, 3, 2, 1, 3};
        MergeSort.sort(values);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3, 3}, values);
    }

    @Test
    void sortArrayWithNegatives() {
        int[] values = {-3, 7, -9, 0, 2};
        MergeSort.sort(values);
        assertArrayEquals(new int[]{-9, -3, 0, 2, 7}, values);
    }
}
