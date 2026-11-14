import java.util.Arrays;

public class SecondBestScore {

    public static int secondHighest(int[] scores) {
        if (scores == null || scores.length < 2) return -1;

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        // Single pass without sorting
        for (int s : scores) {
            if (s > first) {
                second = first;
                first = s;
            } else if (s < first && s > second) {
                second = s;
            }
        }

        return (second == Integer.MIN_VALUE) ? -1 : second;
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment Problem 7: Second-Best Score ===");
        int[] scores1 = {45, 78, 92, 78, 60};
        System.out.println("Scores: " + Arrays.toString(scores1) + " -> Second Highest: " + secondHighest(scores1));

        int[] scores2 = {50, 50, 50};
        System.out.println("Scores: " + Arrays.toString(scores2) + " -> Second Highest: " + secondHighest(scores2));
    }
}
