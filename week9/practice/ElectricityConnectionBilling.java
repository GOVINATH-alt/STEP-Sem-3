public class ElectricityConnectionBilling {

    public abstract static class ElectricityConnection {
        int units;

        public ElectricityConnection(int units) {
            this.units = units;
        }

        public abstract double calculateBill();
        public abstract String getConnectionType();
    }

    public static class DomesticConnection extends ElectricityConnection {
        public DomesticConnection(int units) { super(units); }
        @Override
        public double calculateBill() {
            // First 100 units @ 3.5, next @ 5.0
            if (units <= 100) return units * 3.5;
            return (100 * 3.5) + ((units - 100) * 5.0);
        }
        @Override public String getConnectionType() { return "Domestic"; }
    }

    public static class CommercialConnection extends ElectricityConnection {
        public CommercialConnection(int units) { super(units); }
        @Override
        public double calculateBill() {
            return (units * 8.5) + 150.0; // Fixed commercial surcharge
        }
        @Override public String getConnectionType() { return "Commercial"; }
    }

    public static class IndustrialConnection extends ElectricityConnection {
        public IndustrialConnection(int units) { super(units); }
        @Override
        public double calculateBill() {
            return (units * 12.0) + 500.0;
        }
        @Override public String getConnectionType() { return "Industrial"; }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Electricity Connection Billing ===");
        ElectricityConnection[] connections = {
            new DomesticConnection(150),
            new CommercialConnection(200),
            new IndustrialConnection(1000)
        };

        double totalBilled = 0;
        for (ElectricityConnection c : connections) {
            double bill = c.calculateBill();
            totalBilled += bill;
            System.out.printf("%-12s (%4d units): Rs %.2f%n", c.getConnectionType(), c.units, bill);
        }
        System.out.printf("Total Amount Billed: Rs %.2f%n", totalBilled);
    }
}
