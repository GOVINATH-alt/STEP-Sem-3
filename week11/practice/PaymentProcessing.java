public class PaymentProcessing {

    public interface PaymentMode {
        double processPayment(double amount);
        String getModeName();
    }

    public static class CashPayment implements PaymentMode {
        @Override public double processPayment(double amount) { return amount; }
        @Override public String getModeName() { return "Cash"; }
    }

    public static class CardPayment implements PaymentMode {
        @Override public double processPayment(double amount) { return amount + (amount * 0.02); } // 2% fee
        @Override public String getModeName() { return "Card"; }
    }

    public static class UpiPayment implements PaymentMode {
        @Override public double processPayment(double amount) { return amount; }
        @Override public String getModeName() { return "UPI"; }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: Payment Processing ===");
        PaymentMode[] modes = {
            new CashPayment(),
            new CardPayment(),
            new UpiPayment(),
            new CardPayment()
        };
        double[] amounts = {1000.0, 2000.0, 1500.0, 3000.0};

        double totalProcessed = 0;
        for (int i = 0; i < modes.length; i++) {
            double amt = amounts[i];
            double processed = modes[i].processPayment(amt);
            double fee = processed - amt;
            totalProcessed += processed;
            System.out.printf("%s: amount %.1f, fee %.1f, processed %.1f%n",
                    modes[i].getModeName(), amt, fee, processed);
        }
        System.out.printf("Total Amount Processed: %.1f%n", totalProcessed);
    }
}
