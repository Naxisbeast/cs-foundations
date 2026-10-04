package mini_projects;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class TopKFinderTest {

    @Test
    void topKMatchesSortedReferenceOnSmallInput() {
        int[] values = {5, 1, 9, 3, 7, 2, 8, 4, 6, 0};
        for (int k = 1; k <= 10; k++) {
            assertArrayEquals(TopKFinder.topKSorted(values, k), TopKFinder.topK(values, k));
        }
    }

    @Test
    void topKHandlesDuplicates() {
        int[] values = {3, 1, 3, 3, 2, 5, 5};
        assertArrayEquals(new int[]{3, 3, 5, 5}, TopKFinder.topK(values, 4));
        assertArrayEquals(new int[]{1, 2, 3, 3, 3, 5, 5}, TopKFinder.topK(values, 7));
    }

    @Test
    void kLargerThanArrayReturnsEverything() {
        int[] values = {4, 1, 3};
        assertArrayEquals(new int[]{1, 3, 4}, TopKFinder.topK(values, 5));
    }

    @Test
    void kZeroReturnsEmpty() {
        assertArrayEquals(new int[0], TopKFinder.topK(new int[]{1, 2, 3}, 0));
    }

    @Test
    void rejectsNegativeK() {
        assertThrows(IllegalArgumentException.class, () -> TopKFinder.topK(new int[]{1}, -1));
    }

    @Test
    void matchesSortedReferenceOnRandomArrays() {
        Random random = new Random(42);
        for (int trial = 0; trial < 50; trial++) {
            int n = random.nextInt(100) + 1;
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = random.nextInt(1000);
            }
            int k = random.nextInt(n) + 1;
            assertArrayEquals(TopKFinder.topKSorted(values, k), TopKFinder.topK(values, k));
        }
    }
}
