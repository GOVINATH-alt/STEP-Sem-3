import java.util.Arrays;

public class HeightLineUpBubbleSort {

    public static void lineUp(int[] heights) {
        if (heights == null || heights.length == 0) return;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }
            System.out.printf("Pass %d: %s%n", (i + 1), Arrays.toString(heights));
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Height Line-Up (Bubble Sort) ===");
        int[] h1 = {4, 2, 5, 1};
        System.out.println("Input: " + Arrays.toString(h1));
        lineUp(h1);

        int[] h2 = {1, 3, 2, 4};
        System.out.println("\nInput: " + Arrays.toString(h2));
        lineUp(h2);
    }
}
