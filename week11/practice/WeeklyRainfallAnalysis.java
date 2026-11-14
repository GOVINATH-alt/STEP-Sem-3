public class WeeklyRainfallAnalysis {

    public static void analyzeRainfall(double[] rainfall) {
        System.out.print("Rainfall (mm): ");
        for (double r : rainfall) {
            System.out.print(r + " ");
        }
        System.out.println();

        double total = 0;
        double maxRain = Double.MIN_VALUE;
        int wettestDay = 1;
        int dryDays = 0;

        for (int i = 0; i < rainfall.length; i++) {
            total += rainfall[i];
            if (rainfall[i] > maxRain) {
                maxRain = rainfall[i];
                wettestDay = i + 1;
            }
            if (rainfall[i] == 0.0) {
                dryDays++;
            }
        }

        double avg = total / rainfall.length;
        System.out.printf("Total Rainfall: %.1f mm%n", total);
        System.out.printf("Average Rainfall: %.2f mm%n", avg);
        System.out.printf("Wettest Day: Day %d (%.1f mm)%n", wettestDay, maxRain);
        System.out.printf("Total Dry Days: %d%n", dryDays);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Weekly Rainfall Analysis ===");
        double[] weekly = {12.0, 0.0, 25.0, 18.0, 0.0, 30.0, 15.0};
        analyzeRainfall(weekly);
    }
}
