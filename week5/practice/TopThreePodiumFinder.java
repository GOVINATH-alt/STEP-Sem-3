import java.util.Arrays;

public class TopThreePodiumFinder {

    public static int[] findTopThree(int[] scores) {
        if (scores == null || scores.length < 3) {
            return new int[]{};
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int s : scores) {
            if (s > first) {
                third = second;
                second = first;
                first = s;
            } else if (s > second) {
                third = second;
                second = s;
            } else if (s > third) {
                third = s;
            }
        }

        return new int[]{first, second, third};
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Top-3 Podium Finder (Single Pass) ===");
        int[] scores = {45, 88, 72, 95, 60, 91, 82};
        System.out.println("All Scores: " + Arrays.toString(scores));
        int[] podium = findTopThree(scores);
        System.out.printf("1st Place: %d | 2nd Place: %d | 3rd Place: %d%n", podium[0], podium[1], podium[2]);
    }
}
