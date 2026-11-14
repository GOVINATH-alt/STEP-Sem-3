import java.util.Arrays;

public class TopPerformerTracker {

    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length == 0) {
            return "No scores provided";
        }

        int min = scores[0];
        int max = scores[0];

        // Single pass min/max tracking without sorting
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) min = scores[i];
            if (scores[i] > max) max = scores[i];
        }

        int spread = max - min;
        return String.format("Max: %d | Min: %d | Spread: %d", max, min, spread);
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 3: Top Performer Tracker (Single Pass) ===");
        int[] scores = {12, 85, 45, 92, 38, 7, 76};
        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.println("Analysis: " + findMinMaxSpread(scores));
    }
}
