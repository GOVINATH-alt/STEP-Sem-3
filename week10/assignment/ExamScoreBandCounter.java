import java.util.Arrays;

public class ExamScoreBandCounter {

    // Binary search for first index with score >= val
    private static int lowerBound(int[] scores, int val) {
        int low = 0, high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] >= val) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Binary search for first index with score > val
    private static int upperBound(int[] scores, int val) {
        int low = 0, high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] > val) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) return 0;
        int start = lowerBound(scores, low);
        int end = upperBound(scores, high);
        return Math.max(0, end - start);
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment Problem 4: Exam Score Band Counter ===");
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println("Scores: " + Arrays.toString(scores));
        System.out.println("Count in [42, 58]: " + countInBand(scores, 42, 58)); // 6
        System.out.println("Count in [90, 100]: " + countInBand(scores, 90, 100)); // 0
    }
}
