import java.util.*;

public class PermutationTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String input = sc.nextLine();

        StringPermutation sp = new StringPermutation();
        List<String> permutations = sp.permuteString(input);

        System.out.println("\nOriginal string: " + input);
        System.out.println("Permutations (" + permutations.size() + "):");
        for (String p : permutations) {
            System.out.println(p);
        }

        System.out.println("\nStack trace (push/pop sequence):");
        for (String op : sp.getStackOperations()) {
            System.out.println(op);
        }

        System.out.println("\nCall stack empty after completion? " + sp.isCallStackEmpty());
        sc.close();
    }
}
