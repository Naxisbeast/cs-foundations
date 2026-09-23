package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionExamplesTest {

    @Test
    void factorialOfZeroAndOneIsOne() {
        assertEquals(1, RecursionExamples.factorial(0));
        assertEquals(1, RecursionExamples.factorial(1));
    }

    @Test
    void factorialOfSmallNumbers() {
        assertEquals(120, RecursionExamples.factorial(5));
        assertEquals(720, RecursionExamples.factorial(6));
    }

    @Test
    void factorialRejectsNegatives() {
        assertThrows(IllegalArgumentException.class, () -> RecursionExamples.factorial(-1));
    }

    @Test
    void fibonacciBaseCases() {
        assertEquals(0, RecursionExamples.fibonacci(0));
        assertEquals(1, RecursionExamples.fibonacci(1));
    }

    @Test
    void fibonacciOfSixIsEight() {
        assertEquals(8, RecursionExamples.fibonacci(6));
    }

    @Test
    void fibonacciRejectsNegatives() {
        assertThrows(IllegalArgumentException.class, () -> RecursionExamples.fibonacci(-3));
    }

    @Test
    void sumArrayEmptyOrNullIsZero() {
        assertEquals(0, RecursionExamples.sumArray(new int[]{}, 0));
        assertEquals(0, RecursionExamples.sumArray(null, 0));
    }

    @Test
    void sumArraySumsAllElements() {
        assertEquals(20, RecursionExamples.sumArray(new int[]{2, 4, 6, 8}, 0));
        assertEquals(7, RecursionExamples.sumArray(new int[]{7}, 0));
    }

    @Test
    void sumArrayStopsAtEndOfArray() {
        assertEquals(0, RecursionExamples.sumArray(new int[]{1, 2}, 5));
    }

    @Test
    void sumArrayRejectsNegativeIndex() {
        assertThrows(IllegalArgumentException.class,
                () -> RecursionExamples.sumArray(new int[]{1, 2}, -1));
    }
}
