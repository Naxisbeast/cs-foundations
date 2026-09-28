package dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void baseCasesMatchAcrossAllVersions() {
        assertEquals(0, Fibonacci.recursive(0));
        assertEquals(0, Fibonacci.memoized(0));
        assertEquals(0, Fibonacci.tabulated(0));
        assertEquals(1, Fibonacci.recursive(1));
        assertEquals(1, Fibonacci.memoized(1));
        assertEquals(1, Fibonacci.tabulated(1));
    }

    @Test
    void knownValues() {
        assertEquals(55, Fibonacci.recursive(10));
        assertEquals(55, Fibonacci.memoized(10));
        assertEquals(55, Fibonacci.tabulated(10));
        assertEquals(6765, Fibonacci.memoized(20));
        assertEquals(6765, Fibonacci.tabulated(20));
    }

    @Test
    void allVersionsAgreeForSmallInputs() {
        for (int n = 0; n <= 20; n++) {
            assertEquals(Fibonacci.recursive(n), Fibonacci.memoized(n));
            assertEquals(Fibonacci.recursive(n), Fibonacci.tabulated(n));
        }
    }

    @Test
    void memoizedAndTabulatedHandleLargeInput() {
        // fib(50) = 12586269025 — far beyond what recursive could reach.
        assertEquals(12_586_269_025L, Fibonacci.memoized(50));
        assertEquals(12_586_269_025L, Fibonacci.tabulated(50));
    }

    @Test
    void allVersionsRejectNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.recursive(-1));
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.memoized(-1));
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.tabulated(-1));
    }
}
