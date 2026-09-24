package search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void searchInEmptyArrayReturnsMinusOne() {
        assertEquals(-1, BinarySearch.search(new int[]{}, 5));
        assertEquals(-1, BinarySearch.searchRecursive(new int[]{}, 5));
    }

    @Test
    void searchSingleElement() {
        assertEquals(0, BinarySearch.search(new int[]{7}, 7));
        assertEquals(-1, BinarySearch.search(new int[]{7}, 8));
        assertEquals(0, BinarySearch.searchRecursive(new int[]{7}, 7));
        assertEquals(-1, BinarySearch.searchRecursive(new int[]{7}, 8));
    }

    @Test
    void searchFindsFirstMiddleAndLast() {
        int[] numbers = {2, 4, 6, 8, 10, 12, 14};
        assertEquals(0, BinarySearch.search(numbers, 2));
        assertEquals(3, BinarySearch.search(numbers, 8));
        assertEquals(6, BinarySearch.search(numbers, 14));
        assertEquals(3, BinarySearch.searchRecursive(numbers, 8));
    }

    @Test
    void searchMissingValueReturnsMinusOne() {
        int[] numbers = {2, 4, 6, 8, 10, 12, 14};
        assertEquals(-1, BinarySearch.search(numbers, 7));
        assertEquals(-1, BinarySearch.search(numbers, 1));
        assertEquals(-1, BinarySearch.search(numbers, 15));
        assertEquals(-1, BinarySearch.searchRecursive(numbers, 7));
    }

    @Test
    void searchEvenLengthArray() {
        int[] numbers = {1, 3, 5, 7};
        assertEquals(2, BinarySearch.search(numbers, 5));
        assertEquals(-1, BinarySearch.search(numbers, 6));
    }

    @Test
    void searchWithDuplicatesReturnsAValidIndex() {
        int[] numbers = {1, 3, 3, 3, 5, 7};
        int index = BinarySearch.search(numbers, 3);
        assertTrue(index >= 0 && index < numbers.length);
        assertEquals(3, numbers[index]);
    }

    @Test
    void searchAllowsNegativeValues() {
        int[] numbers = {-9, -4, 0, 2, 11};
        assertEquals(1, BinarySearch.search(numbers, -4));
        assertEquals(-1, BinarySearch.search(numbers, -1));
    }
}
