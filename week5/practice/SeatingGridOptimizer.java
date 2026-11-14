public class SeatingGridOptimizer {

    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) return 0.0;
        int sum = 0;
        for (int val : row) {
            sum += val;
        }
        return (double) sum / row.length;
    }

    public static void classifyRows(int[][] grid, double threshold) {
        System.out.println("Row | Average Score | Status");
        System.out.println("-----------------------------------");
        for (int i = 0; i < grid.length; i++) {
            double avg = rowAverage(grid[i]);
            String status = (avg >= threshold) ? "Humming Along" : "Needs Mentor Help";
            System.out.printf("%-3d | %-13.2f | %s%n", (i + 1), avg, status);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Hackathon Seating Grid Optimizer ===");
        int[][] seatingGrid = {
            {75, 80, 85, 90},
            {40, 55, 45, 50},
            {65, 70, 72, 68}
        };
        classifyRows(seatingGrid, 60.0);
    }
}
