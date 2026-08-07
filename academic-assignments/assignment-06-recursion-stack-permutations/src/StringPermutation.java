import java.util.*;

/**
 * StringPermutation
 * - I generate unique permutations using recursion and swapping.
 * - I explicitly push/pop the current string state onto a Stack to trace recursion.
 */
public class StringPermutation {
    private final Stack<String> callStack = new Stack<>();
    private final List<String> stackOperations = new ArrayList<>(); // "PUSH: ..." / "POP: ..."
    private final LinkedHashSet<String> uniquePerms = new LinkedHashSet<>();

    // Public API. I clear internal state each time I run.
    public List<String> permuteString(String input) {
        callStack.clear();
        stackOperations.clear();
        uniquePerms.clear();

        if (input == null) {
            return Collections.emptyList();
        }

        char[] arr = input.toCharArray();

        // handle empty string: treat as one permutation ""
        if (arr.length == 0) {
            String empty = "";
            callStack.push(empty);
            stackOperations.add("PUSH: " + empty);
            uniquePerms.add(empty);
            callStack.pop();
            stackOperations.add("POP: " + empty);
        } else {
            permute(arr, 0, arr.length - 1);
        }

        return new ArrayList<>(uniquePerms);
    }

    // Recursive worker. I push state on entry and pop on exit.
    private void permute(char[] arr, int left, int right) {
        String state = new String(arr);
        callStack.push(state);
        stackOperations.add("PUSH: " + state);

        if (left == right) {
            uniquePerms.add(state);
            // base-case: pop and return
            String popped = callStack.pop();
            stackOperations.add("POP: " + popped);
            return;
        }

        for (int i = left; i <= right; i++) {
            swap(arr, left, i);
            permute(arr, left + 1, right);
            swap(arr, left, i); // backtrack
        }

        String popped = callStack.pop();
        stackOperations.add("POP: " + popped);
    }

    private void swap(char[] arr, int i, int j) {
        if (i == j) return;
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // Return the push/pop log in order it happened.
    public List<String> getStackOperations() {
        return new ArrayList<>(stackOperations);
    }

    // Utility: confirm stack is empty (should be true after full run).
    public boolean isCallStackEmpty() {
        return callStack.isEmpty();
    }
}
