public class DigitSumAndReversal {

    public static void analyzeNumber(int num) {
        int temp = Math.abs(num);
        int sum = 0;
        int reversed = 0;

        while (temp > 0) {
            int d = temp % 10;
            sum += d;
            reversed = reversed * 10 + d;
            temp /= 10;
        }

        System.out.printf("Number: %d | Digit Sum: %d | Reversed: %d%n", num, sum, reversed);
    }

    public static void main(String[] args) {
        System.out.println("=== DS Practice 5: Digit Sum and Number Reversal ===");
        analyzeNumber(12345);
        analyzeNumber(9870);
    }
}
