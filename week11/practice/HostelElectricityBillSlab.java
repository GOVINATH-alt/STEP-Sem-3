public class HostelElectricityBillSlab {

    public static int calculateRoomBill(int units) {
        if (units < 0) return -1;
        int cost = 0;
        if (units <= 100) {
            cost = units * 3;
        } else if (units <= 200) {
            cost = (100 * 3) + ((units - 100) * 5);
        } else {
            cost = (100 * 3) + (100 * 5) + ((units - 200) * 8);
        }
        return cost + 50; // Fixed meter charge
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 6: Hostel Electricity Bill Slabs ===");
        String[] rooms = {"A101", "A102", "B201", "B202", "C301"};
        int[] units = {80, 150, 260, -12, 200};

        int billedCount = 0;
        int grandTotal = 0;

        for (int i = 0; i < rooms.length; i++) {
            int bill = calculateRoomBill(units[i]);
            if (bill == -1) {
                System.out.printf("%s: invalid reading%n", rooms[i]);
            } else {
                System.out.printf("%s: %d units, bill %d%n", rooms[i], units[i], bill);
                billedCount++;
                grandTotal += bill;
            }
        }
        System.out.printf("Rooms billed %d, total %d%n", billedCount, grandTotal);
    }
}
