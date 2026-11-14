import java.util.Arrays;

public class HackathonScoreCurveBooster {

    public static void curveScores(int[] scores, int boost) {
        if (scores == null) return;
        for (int i = 0; i < scores.length; i++) {
            scores[i] += boost;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Hackathon Score Curve Booster ===");
        int[] scores = {65, 72, 58, 80, 45};
        System.out.println("Original Scores: " + Arrays.toString(scores));
        curveScores(scores, 10);
        System.out.println("Curved Scores (+10): " + Arrays.toString(scores));
    }
}
