public class WarehouseBinGridScan {

    public static String scanGrid(String[][] grid, String targetSku) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c].equalsIgnoreCase(targetSku)) {
                    return String.format("Found at Bin [%d, %d]", r, c);
                }
            }
        }
        return "SKU Not Found";
    }

    public static void main(String[] args) {
        System.out.println("=== DS P2: Warehouse Bin Grid Scan ===");
        String[][] bins = {
            {"SKU-10", "SKU-20", "SKU-30"},
            {"SKU-40", "SKU-50", "SKU-60"}
        };
        System.out.println(scanGrid(bins, "SKU-50"));
        System.out.println(scanGrid(bins, "SKU-99"));
    }
}
