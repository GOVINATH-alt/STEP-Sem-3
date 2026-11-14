import java.util.Arrays;

public class ClassAttendanceTracker {

    public static class AttendanceResult {
        public int presentDays;
        public int longestStreak;

        public AttendanceResult(int p, int s) {
            this.presentDays = p;
            this.longestStreak = s;
        }

        @Override
        public String toString() {
            return String.format("Present: %d, Longest streak: %d", presentDays, longestStreak);
        }
    }

    public static AttendanceResult attendanceSummary(int[] days) {
        int present = 0;
        int maxStreak = 0;
        int currentStreak = 0;

        for (int d : days) {
            if (d == 1) {
                present++;
                currentStreak++;
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new AttendanceResult(present, maxStreak);
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment Problem 6: Class Attendance Tracker ===");
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        System.out.println("Days 1: " + Arrays.toString(days1) + " -> " + attendanceSummary(days1));

        int[] days2 = {0, 0, 0};
        System.out.println("Days 2: " + Arrays.toString(days2) + " -> " + attendanceSummary(days2));
    }
}
