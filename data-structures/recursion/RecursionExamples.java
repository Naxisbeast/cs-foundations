package recursion;

public class RecursionExamples {
    public static int factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial does not accept negative numbers.");
        }

        if (number == 0 || number == 1) {
            return 1;
        }

        return number * factorial(number - 1);
    }

    public static int fibonacci(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Fibonacci does not accept negative numbers.");
        }

        if (number == 0) {
            return 0;
        }

        if (number == 1) {
            return 1;
        }

        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public static int sumArray(int[] numbers, int index) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        if (index < 0) {
            throw new IllegalArgumentException("Array index cannot be negative.");
        }

        if (index >= numbers.length) {
            return 0;
        }

        return numbers[index] + sumArray(numbers, index + 1);
    }

    public static void countdown(int number) {
        if (number < 0) {
            System.out.println("Countdown complete.");
            return;
        }

        System.out.println(number);
        countdown(number - 1);
    }
}
