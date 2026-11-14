public class CanteenBillingCounter {

    public abstract static class Customer {
        String type;
        double amount;

        public Customer(String type, double amount) {
            this.type = type;
            this.amount = amount;
        }

        public abstract double calculateFinalAmount();
    }

    public static class StudentCustomer extends Customer {
        public StudentCustomer(double amount) { super("STUDENT", amount); }
        @Override
        public double calculateFinalAmount() {
            return amount * 0.90; // 10% discount
        }
    }

    public static class StaffCustomer extends Customer {
        public StaffCustomer(double amount) { super("STAFF", amount); }
        @Override
        public double calculateFinalAmount() {
            return amount * 0.95; // 5% discount
        }
    }

    public static class GuestCustomer extends Customer {
        public GuestCustomer(double amount) { super("GUEST", amount); }
        @Override
        public double calculateFinalAmount() {
            return amount + 10.0; // full amount + 10 service charge
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 1: The Canteen Billing Counter ===");
        Customer[] bills = {
            new StudentCustomer(200),
            new StaffCustomer(300),
            new GuestCustomer(150)
        };

        double grandTotal = 0;
        for (Customer c : bills) {
            double finalAmt = c.calculateFinalAmount();
            grandTotal += finalAmt;
            System.out.printf("%s: %.2f%n", c.type, finalAmt);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
