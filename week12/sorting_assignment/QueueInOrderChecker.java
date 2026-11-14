import java.util.Arrays;

public class QueueInOrderChecker {

    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) return -1;

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Is the Queue in Order? ===");
        int[] t1 = {3, 5, 5, 8, 6, 9};
        System.out.println("Tokens: " + Arrays.toString(t1) + " -> Break at index: " + firstBreak(t1));

        int[] t2 = {1, 2, 2, 7};
        System.out.println("Tokens: " + Arrays.toString(t2) + " -> Break at index: " + firstBreak(t2));
    }
}
