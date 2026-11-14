public class BusiestBusRow {

    public static class RowResult {
        public int rowIndex;
        public int totalStudents;

        public RowResult(int r, int t) {
            this.rowIndex = r;
            this.totalStudents = t;
        }

        @Override
        public String toString() {
            return String.format("Row %d, Total %d", rowIndex, totalStudents);
        }
    }

    public static RowResult busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) return new RowResult(-1, 0);

        int bestRow = 0;
        int maxTotal = Integer.MIN_VALUE;

        for (int r = 0; r < grid.length; r++) {
            int rowSum = 0;
            for (int c = 0; c < grid[r].length; c++) {
                rowSum += grid[r][c];
            }
            if (rowSum > maxTotal) {
                maxTotal = rowSum;
                bestRow = r;
            }
        }

        return new RowResult(bestRow, maxTotal);
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment Problem 10: Busiest Bus Row ===");
        int[][] busGrid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        System.out.println("Result: " + busiestRow(busGrid));
    }
}
