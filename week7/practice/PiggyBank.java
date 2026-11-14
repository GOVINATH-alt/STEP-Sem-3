public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public String getId() {
        return id;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
            System.out.printf("deposit(%.0f) -> savings = %.0f%n", amount, savings);
        }
    }

    public void withdraw(double amount) {
        if (amount <= savings && amount > 0) {
            savings -= amount;
            System.out.printf("withdraw(%.0f) -> savings = %.0f%n", amount, savings);
        } else {
            System.out.printf("withdraw(%.0f) -> rejected, savings stays %.0f%n", amount, savings);
        }
    }

    public double getSavings() {
        return savings;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: The Piggy Bank ===");
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}
