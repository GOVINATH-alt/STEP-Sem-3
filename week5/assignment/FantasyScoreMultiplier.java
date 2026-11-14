import java.util.Arrays;

public class FantasyScoreMultiplier {

    public static void applyMultipliers(double[] playerScores, int captainIdx, int viceCaptainIdx) {
        if (playerScores == null) return;
        if (captainIdx >= 0 && captainIdx < playerScores.length) {
            playerScores[captainIdx] *= 2.0;
        }
        if (viceCaptainIdx >= 0 && viceCaptainIdx < playerScores.length) {
            playerScores[viceCaptainIdx] *= 1.5;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 1: Fantasy Team Score Multiplier ===");
        double[] lineup = {40.0, 50.0, 30.0, 62.0, 25.0};
        int cap = 1;      // index 1: 50 * 2 = 100
        int viceCap = 3;  // index 3: 62 * 1.5 = 93
        System.out.println("Before Multipliers: " + Arrays.toString(lineup));
        applyMultipliers(lineup, cap, viceCap);
        System.out.println("After Multipliers:  " + Arrays.toString(lineup));
    }
}
