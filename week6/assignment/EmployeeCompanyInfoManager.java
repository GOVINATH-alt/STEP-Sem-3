public class EmployeeCompanyInfoManager {

    public static class Employee {
        String empName;
        double salary;

        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++;
        }

        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment M5: Employee & Company Information Management ===");
        new Employee("Arun", 50000.0);
        new Employee("Bala", 60000.0);
        new Employee("Chitra", 55000.0);

        Employee.printCompanyInfo();
    }
}
