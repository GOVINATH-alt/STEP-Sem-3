public class MatchDayGridAnalyzer {

    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0.0;
        int sum = 0;
        for (int r : row) sum += r;
        return (double) sum / row.length;
    }

    public static void analyzeMatches(int[][] matchRuns, double threshold) {
        System.out.println("Match | Avg Runs/Over | Rating");
        System.out.println("-------------------------------------");
        for (int i = 0; i < matchRuns.length; i++) {
            double avg = rowAverage(matchRuns[i]);
            String rating = (avg >= threshold) ? "Power Surge" : "Normal";
            System.out.printf("Match %-2d | %-13.2f | %s%n", (i + 1), avg, rating);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 4: Match Day Grid Analyzer ===");
        int[][] matches = {
            {8, 12, 10, 15, 9},   // Avg = 10.8
            {4, 6, 5, 7, 5},      // Avg = 5.4
            {10, 14, 11, 16, 12}  // Avg = 12.6
        };
        analyzeMatches(matches, 9.0);
    }
}
