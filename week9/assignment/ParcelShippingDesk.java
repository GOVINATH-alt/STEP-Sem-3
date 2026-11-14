public class ParcelShippingDesk {

    public interface Insurable {
        double calculateInsurance();
    }

    public abstract static class Parcel {
        double weightKg;
        double declaredValue;

        public Parcel(double weightKg, double declaredValue) {
            this.weightKg = weightKg;
            this.declaredValue = declaredValue;
        }

        public abstract double getBaseShippingCharge();
        public abstract String getParcelType();

        public double getTotalCharge() {
            double total = getBaseShippingCharge();
            if (this instanceof Insurable) {
                total += ((Insurable) this).calculateInsurance();
            }
            return total;
        }
    }

    public static class StandardParcel extends Parcel {
        public StandardParcel(double weight, double value) { super(weight, value); }
        @Override public double getBaseShippingCharge() { return weightKg * 40.0; }
        @Override public String getParcelType() { return "Standard"; }
    }

    public static class ExpressParcel extends Parcel implements Insurable {
        public ExpressParcel(double weight, double value) { super(weight, value); }
        @Override public double getBaseShippingCharge() { return weightKg * 80.0 + 50.0; }
        @Override public double calculateInsurance() { return declaredValue * 0.02; }
        @Override public String getParcelType() { return "Express"; }
    }

    public static class FragileParcel extends Parcel implements Insurable {
        public FragileParcel(double weight, double value) { super(weight, value); }
        @Override public double getBaseShippingCharge() { return weightKg * 100.0 + 100.0; }
        @Override public double calculateInsurance() { return declaredValue * 0.05; }
        @Override public String getParcelType() { return "Fragile"; }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 2: Parcel Shipping Desk ===");
        Parcel[] parcels = {
            new StandardParcel(5.0, 1000),
            new ExpressParcel(3.0, 5000),
            new FragileParcel(2.0, 10000)
        };

        for (Parcel p : parcels) {
            System.out.printf("%-10s (%4.1f kg, Val Rs %.0f): Total Charge = Rs %.2f%n",
                    p.getParcelType(), p.weightKg, p.declaredValue, p.getTotalCharge());
        }
    }
}
