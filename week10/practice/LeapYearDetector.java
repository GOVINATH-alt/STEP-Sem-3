public class LeapYearDetector {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        System.out.println("=== DS Practice 9: Leap Year Detector ===");
        int[] years = {1900, 2000, 2024, 2026, 2028};
        for (int y : years) {
            System.out.printf("%d is %s%n", y, isLeapYear(y) ? "a Leap Year" : "not a Leap Year");
        }
    }
}
