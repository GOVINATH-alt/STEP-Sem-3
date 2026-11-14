public class EmployeeProfileManager {

    public static class Employee {
        String empId;
        String empName;
        double salary;
        boolean isIntern;

        public Employee(String empId, String empName, double salary) {
            this.empId = empId;
            this.empName = empName;
            this.salary = salary;
            this.isIntern = false;
        }

        // Chained constructor for interns
        public Employee(String empId, String empName) {
            this(empId, empName, 0.0);
            this.isIntern = true;
        }

        public void printProfile() {
            System.out.printf("%s | %s | Rs %.1f | Intern: %s%n", empId, empName, salary, isIntern);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment M3: Employee Profile Creation ===");
        Employee perm = new Employee("E-101", "Divya", 65000.0);
        Employee intern = new Employee("E-102", "Arjun");

        perm.printProfile();
        intern.printProfile();
    }
}
