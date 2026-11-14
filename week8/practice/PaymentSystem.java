public class PaymentSystem {

    public abstract static class Payment {
        double amount;

        public Payment(double amount) {
            this.amount = amount;
        }

        public abstract double calculateFinalAmount();
        public abstract String getMethodName();
    }

    public static class CreditCardPayment extends Payment {
        public CreditCardPayment(double amount) { super(amount); }
        @Override
        public double calculateFinalAmount() { return amount + (amount * 0.02); } // 2% fee
        @Override
        public String getMethodName() { return "Credit Card"; }
    }

    public static class UpiPayment extends Payment {
        public UpiPayment(double amount) { super(amount); }
        @Override
        public double calculateFinalAmount() { return amount; } // 0% fee
        @Override
        public String getMethodName() { return "UPI"; }
    }

    public static class NetBankingPayment extends Payment {
        public NetBankingPayment(double amount) { super(amount); }
        @Override
        public double calculateFinalAmount() { return amount + 15.0; } // flat 15 fee
        @Override
        public String getMethodName() { return "NetBanking"; }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Payment System Fee Calculation ===");
        Payment[] payments = {
            new CreditCardPayment(1000),
            new UpiPayment(500),
            new NetBankingPayment(2000)
        };

        double grandTotal = 0;
        for (Payment p : payments) {
            double finalAmt = p.calculateFinalAmount();
            grandTotal += finalAmt;
            System.out.printf("%s: Base=%.2f, Final=%.2f%n", p.getMethodName(), p.amount, finalAmt);
        }
        System.out.printf("Total Processed: %.2f%n", grandTotal);
    }
}
