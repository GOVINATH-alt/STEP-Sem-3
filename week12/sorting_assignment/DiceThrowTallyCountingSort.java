import java.util.Arrays;

public class DiceThrowTallyCountingSort {

    public static int[] diceSort(int[] rolls) {
        if (rolls == null) return new int[]{};
        int[] count = new int[7]; // 1 to 6

        for (int r : rolls) {
            if (r >= 1 && r <= 6) {
                count[r]++;
            }
        }

        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.printf("%d:%d%s", v, count[v], v < 6 ? "  " : "\n");
        }

        int[] sorted = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int k = 0; k < count[v]; k++) {
                sorted[idx++] = v;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: The Dice Throw Tally (Counting Sort) ===");
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        System.out.println("Rolls: " + Arrays.toString(rolls));
        int[] sorted = diceSort(rolls);
        System.out.println("Sorted: " + Arrays.toString(sorted));
    }
}
