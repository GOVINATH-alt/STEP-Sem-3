public class PayrollSalaryManager {

    public static class SalaryAccount {
        private double basicSalary;
        private double bonus;

        public SalaryAccount(double basicSalary) {
            this.basicSalary = Math.max(0, basicSalary);
            this.bonus = 0.0;
        }

        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Bonus must be positive.");
                return;
            }
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }

        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Tax percentage must be between 0 and 100.");
                return;
            }
            double tax = (basicSalary * percent) / 100.0;
            basicSalary -= tax;
            System.out.printf("Tax deducted: %.0f%%%n", percent);
        }

        public double getNetSalary() {
            return basicSalary + bonus;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment M2: Payroll Salary Management ===");
        SalaryAccount acc = new SalaryAccount(50000.0);
        acc.creditBonus(5000.0);
        acc.deductTax(10.0);
        System.out.println("Net salary: Rs " + acc.getNetSalary());
    }
}
