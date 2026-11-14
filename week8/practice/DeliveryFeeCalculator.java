public class DeliveryFeeCalculator {

    public abstract static class Delivery {
        double weightKg;
        double distanceKm;

        public Delivery(double weightKg, double distanceKm) {
            this.weightKg = weightKg;
            this.distanceKm = distanceKm;
        }

        public abstract double calculateFee();
    }

    public static class StandardDelivery extends Delivery {
        public StandardDelivery(double weightKg, double distanceKm) { super(weightKg, distanceKm); }
        @Override
        public double calculateFee() { return (weightKg * 5) + (distanceKm * 2); }
    }

    public static class ExpressDelivery extends Delivery {
        public ExpressDelivery(double weightKg, double distanceKm) { super(weightKg, distanceKm); }
        @Override
        public double calculateFee() { return (weightKg * 10) + (distanceKm * 5) + 50; }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Delivery Fee Calculator ===");
        Delivery[] deliveries = {
            new StandardDelivery(10, 50),
            new ExpressDelivery(10, 50)
        };

        for (Delivery d : deliveries) {
            System.out.printf("%s Fee: Rs %.2f%n", d.getClass().getSimpleName(), d.calculateFee());
        }
    }
}
