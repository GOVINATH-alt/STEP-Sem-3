public class SeatDuplicationChecker {

    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null || seatNumbers.length == 0) {
            System.out.println("No seat numbers provided.");
            return;
        }

        boolean foundDuplicate = false;
        // Use arrays and loops only (no Collections)
        boolean[] reported = new boolean[seatNumbers.length];

        for (int i = 0; i < seatNumbers.length; i++) {
            if (reported[i]) continue;
            boolean isDup = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isDup = true;
                    reported[j] = true;
                }
            }
            if (isDup) {
                foundDuplicate = true;
                System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
            }
        }

        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Exam Hall Seat Duplication Checker ===");
        int[] batch1 = {101, 102, 103, 102, 105};
        System.out.print("Test Case 1 {101, 102, 103, 102, 105}: ");
        checkDuplicateSeats(batch1);

        int[] batch2 = {101, 102, 103, 104, 105};
        System.out.print("Test Case 2 {101, 102, 103, 104, 105}: ");
        checkDuplicateSeats(batch2);
    }
}
