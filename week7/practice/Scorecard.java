public class Scorecard {
    private final int totalQuestions;
    private final boolean[] results;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (recordedCount < totalQuestions) {
            results[recordedCount++] = isCorrect;
        } else {
            System.out.println("All questions already recorded.");
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < recordedCount; i++) {
            if (results[i]) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: The Quiz Scorecard ===");
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("Final Score: " + sc.getScore());
    }
}
