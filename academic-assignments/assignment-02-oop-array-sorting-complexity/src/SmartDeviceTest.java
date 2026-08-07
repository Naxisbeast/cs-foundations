import java.util.Arrays;
import java.util.Random;

public class SmartDeviceTest {
    public static void main(String[] args) {
        int totalDevices = 10;
        SmartDevice[] list = new SmartDevice[totalDevices];
        Random random = new Random();
        int totalWatches = 0;
        int totalSpeakers = 0;

        // Fill array with random devices
        for (int i = 0; i < totalDevices; i++) {
            if (random.nextBoolean()) {
                list[i] = new SmartWatch("FitBit", "Versa " + i, random.nextInt(100), true);
                totalWatches++;
            } else {
                list[i] = new SmartSpeaker("Amazon", "Echo " + i, random.nextInt(100), "Alexa");
                totalSpeakers++;
            }
        }

        // Display original device list
        System.out.println("== DEVICE LIST BEFORE SORT ==");
        for (SmartDevice d : list) {
            System.out.println(d);                // Implicit toString
            d.activateFeature();                  // Polymorphism
            System.out.println(d.toString());     // Explicit toString
            System.out.println();
        }

        // Sort by battery life
        Arrays.sort(list);

        // Display sorted list
        System.out.println("== DEVICE LIST AFTER SORT ==");
        for (SmartDevice d : list) {
            System.out.println(d);
        }

        // Call complexity breakdown
        showRuntimeBreakdown(totalDevices, totalWatches, totalSpeakers);
    }

    public static void showRuntimeBreakdown(int count, int watchTotal, int speakerTotal) {
        System.out.println("\n===== RUNTIME ANALYSIS =====");

        // Tau-based model
        System.out.println("\n1. DETAILED MODEL (τ-notation)");
        System.out.println("- Loop Setup: τ fetch + τ store");
        System.out.println("- Loop Condition: (n + 1)(2τ + τ)");
        System.out.println("- Step Increment: n(2τ + τ + τ)");
        System.out.println("- Object Instantiation: n(τ creation)");
        System.out.println("- Sorting Call: τ(n log n)");
        System.out.println("=> Combined total τ: τ fetch + τ store + 3(n+1) + 4n + τ(n log n)");

        // Simplified runtime: all τs = 1
        int simplifiedTotal = 2 + 3 * (count + 1) + 4 * count;
        System.out.println("\n2. SIMPLIFIED CALCULATION (τ = 1)");
        System.out.println("Operations total: 2 + 3(n+1) + 4n = " + simplifiedTotal);

        // Asymptotic notation
        System.out.println("\n3. ASYMPTOTIC ANALYSIS (Big O)");
        System.out.println("- Loop that builds devices: O(n)");
        System.out.println("- Sorting: O(n log n)");
        System.out.println("- Feature activation loop: O(n)");
        System.out.println("→ Final time complexity: O(n log n)");

        // Class-specific breakdown
        System.out.println("\n4. DEVICE TYPE COUNT");
        System.out.println("- SmartWatch objects: " + watchTotal + " → O(n)");
        System.out.println("- SmartSpeaker objects: " + speakerTotal + " → O(n)");
    }
}
