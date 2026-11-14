public class CampusStaffSalary {

    public static class Staff {
        String name;
        double baseSalary;

        public Staff(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }

        public double getBonus() { return 0.0; }
        public String getRole() { return "Staff"; }
        public double getTotalSalary() { return baseSalary + getBonus(); }
    }

    public static class Teacher extends Staff {
        public Teacher(String name, double baseSalary) { super(name, baseSalary); }
        @Override public double getBonus() { return 5000.0; }
        @Override public String getRole() { return "Teacher"; }
    }

    public static class LabAssistant extends Staff {
        public LabAssistant(String name, double baseSalary) { super(name, baseSalary); }
        @Override public double getBonus() { return 2000.0; }
        @Override public String getRole() { return "LabAssistant"; }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 1: Campus Staff Salary ===");
        Staff[] staffList = {
            new Teacher("Rahul", 30000),
            new LabAssistant("Priya", 20000),
            new Staff("Amit", 25000),
            new Teacher("Sneha", 35000),
            new LabAssistant("Karan", 18000)
        };

        double grandTotal = 0;
        for (Staff s : staffList) {
            grandTotal += s.getTotalSalary();
            System.out.printf("%s (%s): base %.1f, bonus %.1f, total %.1f%n",
                    s.name, s.getRole(), s.baseSalary, s.getBonus(), s.getTotalSalary());
        }
        System.out.printf("Grand Total Salary: %.1f%n", grandTotal);
    }
}
