import java.util.Arrays;

public class PrizeTableSelectionSort {

    public static int prizeTable(int[] marks) {
        if (marks == null) return 0;
        int n = marks.length;
        int totalSwaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                int temp = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = temp;
                totalSwaps++;
            }
        }
        return totalSwaps;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: The Prize Table (Selection Sort Descending) ===");
        int[] m1 = {45, 90, 60, 75};
        System.out.println("Input: " + Arrays.toString(m1));
        int s1 = prizeTable(m1);
        System.out.println("Sorted: " + Arrays.toString(m1) + "  swaps = " + s1);

        int[] m2 = {80, 70, 60};
        System.out.println("\nInput: " + Arrays.toString(m2));
        int s2 = prizeTable(m2);
        System.out.println("Sorted: " + Arrays.toString(m2) + "  swaps = " + s2);
    }
}
