public class HomeApplianceEnergyReport {

    public interface SaverMode {
        double getPowerReductionPercent();
    }

    public abstract static class Appliance {
        String name;
        double powerRatingWatts;
        double hoursPerDay;

        public Appliance(String name, double powerRatingWatts, double hoursPerDay) {
            this.name = name;
            this.powerRatingWatts = powerRatingWatts;
            this.hoursPerDay = hoursPerDay;
        }

        public abstract double getEffectiveWatts();

        public double calculateMonthlyCost(double ratePerKwh) {
            double dailyKwh = (getEffectiveWatts() * hoursPerDay) / 1000.0;
            return dailyKwh * 30 * ratePerKwh;
        }
    }

    public static class Refrigerator extends Appliance {
        public Refrigerator(double hours) { super("Refrigerator", 200, hours); }
        @Override public double getEffectiveWatts() { return powerRatingWatts; }
    }

    public static class AirConditioner extends Appliance implements SaverMode {
        boolean saverEnabled;
        public AirConditioner(double hours, boolean saverEnabled) {
            super("Air Conditioner", 1500, hours);
            this.saverEnabled = saverEnabled;
        }
        @Override public double getPowerReductionPercent() { return 0.25; }
        @Override
        public double getEffectiveWatts() {
            return saverEnabled ? powerRatingWatts * (1 - getPowerReductionPercent()) : powerRatingWatts;
        }
    }

    public static class Television extends Appliance {
        public Television(double hours) { super("Television", 100, hours); }
        @Override public double getEffectiveWatts() { return powerRatingWatts; }
    }

    public static class WashingMachine extends Appliance implements SaverMode {
        boolean ecoMode;
        public WashingMachine(double hours, boolean ecoMode) {
            super("Washing Machine", 500, hours);
            this.ecoMode = ecoMode;
        }
        @Override public double getPowerReductionPercent() { return 0.30; }
        @Override
        public double getEffectiveWatts() {
            return ecoMode ? powerRatingWatts * (1 - getPowerReductionPercent()) : powerRatingWatts;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 5: Home Appliance Energy Report ===");
        double rate = 7.5; // Rs per kWh
        Appliance[] appliances = {
            new Refrigerator(24),
            new AirConditioner(8, true),
            new Television(5),
            new WashingMachine(1.5, true)
        };

        double grandTotal = 0;
        for (Appliance a : appliances) {
            double cost = a.calculateMonthlyCost(rate);
            grandTotal += cost;
            System.out.printf("%-18s (%.1f hrs/day): Rs %.2f/month%n", a.name, a.hoursPerDay, cost);
        }
        System.out.printf("Total Monthly Electricity Cost: Rs %.2f%n", grandTotal);
    }
}
