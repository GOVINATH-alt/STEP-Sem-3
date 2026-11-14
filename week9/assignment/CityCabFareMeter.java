public class CityCabFareMeter {

    public interface NightService {
        double NIGHT_SURCHARGE_PERCENT = 0.20; // 20% surcharge
    }

    public abstract static class Cab {
        static final double MINIMUM_FARE = 100.0; // No trip costs less than 100
        double distanceKm;
        boolean isNightTrip;

        public Cab(double distanceKm, boolean isNightTrip) {
            this.distanceKm = distanceKm;
            this.isNightTrip = isNightTrip;
        }

        public abstract double getRatePerKm();
        public abstract String getCabType();

        public double calculateFare() {
            double fare = distanceKm * getRatePerKm();
            if (this instanceof NightService && isNightTrip) {
                fare += fare * NightService.NIGHT_SURCHARGE_PERCENT;
            }
            return Math.max(MINIMUM_FARE, fare);
        }
    }

    public static class MiniCab extends Cab {
        public MiniCab(double dist) { super(dist, false); } // Mini has no night service
        @Override public double getRatePerKm() { return 12.0; }
        @Override public String getCabType() { return "Mini"; }
    }

    public static class SedanCab extends Cab implements NightService {
        public SedanCab(double dist, boolean isNight) { super(dist, isNight); }
        @Override public double getRatePerKm() { return 16.0; }
        @Override public String getCabType() { return "Sedan"; }
    }

    public static class SuvCab extends Cab implements NightService {
        public SuvCab(double dist, boolean isNight) { super(dist, isNight); }
        @Override public double getRatePerKm() { return 22.0; }
        @Override public String getCabType() { return "SUV"; }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 4: City Cab Fare Meter ===");
        Cab[] rides = {
            new MiniCab(5.0),           // 5 * 12 = 60 -> min fare 100
            new SedanCab(15.0, false),  // 15 * 16 = 240
            new SedanCab(15.0, true),   // 240 + 20% = 288
            new SuvCab(20.0, true)      // 20 * 22 = 440 + 20% = 528
        };

        for (Cab c : rides) {
            System.out.printf("%-6s (%4.1f km, Night: %-5s) -> Fare: Rs %.2f%n",
                    c.getCabType(), c.distanceKm, c.isNightTrip, c.calculateFare());
        }
    }
}
