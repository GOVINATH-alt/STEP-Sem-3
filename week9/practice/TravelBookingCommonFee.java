public class TravelBookingCommonFee {

    public abstract static class TravelBooking {
        static final double BOOKING_FEE = 50.0; // Defined in one place only
        double distanceKm;

        public TravelBooking(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        public abstract double getBaseFare();
        public abstract String getMode();

        public double calculateTotalFare() {
            return getBaseFare() + BOOKING_FEE;
        }
    }

    public static class BusBooking extends TravelBooking {
        public BusBooking(double distanceKm) { super(distanceKm); }
        @Override public double getBaseFare() { return distanceKm * 2.0; }
        @Override public String getMode() { return "Bus"; }
    }

    public static class TrainBooking extends TravelBooking {
        public TrainBooking(double distanceKm) { super(distanceKm); }
        @Override public double getBaseFare() { return distanceKm * 1.5; }
        @Override public String getMode() { return "Train"; }
    }

    public static class FlightBooking extends TravelBooking {
        public FlightBooking(double distanceKm) { super(distanceKm); }
        @Override public double getBaseFare() { return (distanceKm * 6.0) + 1000.0; }
        @Override public String getMode() { return "Flight"; }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Travel Booking with Common Platform Fee ===");
        TravelBooking[] trips = {
            new BusBooking(100),
            new TrainBooking(300),
            new FlightBooking(800)
        };

        for (TravelBooking t : trips) {
            System.out.printf("%-8s (%.0f km): Base=%.2f, Platform Fee=%.2f, Total=Rs %.2f%n",
                    t.getMode(), t.distanceKm, t.getBaseFare(), TravelBooking.BOOKING_FEE, t.calculateTotalFare());
        }
    }
}
