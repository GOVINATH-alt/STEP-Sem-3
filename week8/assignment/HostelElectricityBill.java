public class HostelElectricityBill {

    public abstract static class Room {
        String type;
        int units;

        public Room(String type, int units) {
            this.type = type;
            this.units = units;
        }

        public abstract double calculateBill();
    }

    public static class SingleRoom extends Room {
        public SingleRoom(int units) { super("SINGLE", units); }
        @Override
        public double calculateBill() {
            return units * 8.0;
        }
    }

    public static class SharedRoom extends Room {
        int occupants;
        public SharedRoom(int units, int occupants) {
            super("SHARED", units);
            this.occupants = Math.max(1, occupants);
        }
        @Override
        public double calculateBill() {
            return (units * 6.0) / occupants;
        }
    }

    public static class AcRoom extends Room {
        public AcRoom(int units) { super("AC", units); }
        @Override
        public double calculateBill() {
            return (units * 10.0) + 200.0;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 3: The Hostel Electricity Bill ===");
        Room[] rooms = {
            new SingleRoom(120),
            new SharedRoom(150, 3),
            new AcRoom(100)
        };

        double grandTotal = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f%n", r.type, bill);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
