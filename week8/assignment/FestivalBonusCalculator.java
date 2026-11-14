public class FestivalBonusCalculator {

    public abstract static class Employee {
        String name;
        double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public abstract double calculateBonus();
    }

    public static class FullTimeEmployee extends Employee {
        public FullTimeEmployee(String name, double salary) { super(name, salary); }
        @Override
        public double calculateBonus() {
            return salary * 0.10;
        }
    }

    public static class PartTimeEmployee extends Employee {
        public PartTimeEmployee(String name, double salary) { super(name, salary); }
        @Override
        public double calculateBonus() {
            return salary * 0.05;
        }
    }

    public static class InternEmployee extends Employee {
        public InternEmployee(String name, double salary) { super(name, salary); }
        @Override
        public double calculateBonus() {
            return 2000.0;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 4: The Festival Bonus Calculator ===");
        Employee[] employees = {
            new FullTimeEmployee("Asha", 50000),
            new PartTimeEmployee("Ravi", 30000),
            new InternEmployee("Neha", 15000)
        };

        double totalBonus = 0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            totalBonus += bonus;
            System.out.printf("%s: %.2f%n", e.name, bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", totalBonus);
    }
}
