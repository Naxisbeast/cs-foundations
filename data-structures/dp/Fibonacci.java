package dp;

/**
 * Three versions of the same function, showing why dynamic programming exists.
 *
 *   recursive   O(2^n) time, O(n) stack depth  — recomputes every subproblem
 *   memoized    O(n)   time, O(n) space         — top-down: remember answers
 *   tabulated   O(n)   time, O(1) space         — bottom-up: two rolling values
 *
 * The memoized and tabulated versions agree on every input but the recursive
 * one is unusable past n ~ 40 because of exponential recomputation.
 */
public final class Fibonacci {

    private Fibonacci() {
        // utility class
    }

    public static long recursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative.");
        }
        if (n <= 1) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    public static long memoized(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative.");
        }
        return memoized(n, new long[n + 1]);
    }

    private static long memoized(int n, long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = memoized(n - 1, memo) + memoized(n - 2, memo);
        return memo[n];
    }

    public static long tabulated(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n cannot be negative.");
        }
        if (n <= 1) {
            return n;
        }
        long previous = 0;
        long current = 1;
        for (int i = 2; i <= n; i++) {
            long next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }
}
