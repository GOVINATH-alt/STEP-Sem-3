public class PublicTransportFareCalculator {

    public abstract static class PublicTransport {
        double distanceKm;

        public PublicTransport(double distanceKm) {
            this.distanceKm = distanceKm;
        }

        public abstract double calculateFare();
    }

    public static class Bus extends PublicTransport {
        public Bus(double distanceKm) { super(distanceKm); }
        @Override public double calculateFare() { return Math.max(10, distanceKm * 2.5); }
    }

    public static class Metro extends PublicTransport {
        public Metro(double distanceKm) { super(distanceKm); }
        @Override public double calculateFare() { return Math.max(20, distanceKm * 4.0); }
    }

    public static class Train extends PublicTransport {
        public Train(double distanceKm) { super(distanceKm); }
        @Override public double calculateFare() { return Math.max(15, distanceKm * 1.8); }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: Public Transport Fare Calculator ===");
        PublicTransport[] journeys = {
            new Bus(15),
            new Metro(15),
            new Train(15)
        };

        double total = 0;
        for (PublicTransport pt : journeys) {
            double fare = pt.calculateFare();
            total += fare;
            System.out.printf("%-6s Fare for 15km: Rs %.2f%n", pt.getClass().getSimpleName(), fare);
        }
        System.out.printf("Total Fare: Rs %.2f%n", total);
    }
}
