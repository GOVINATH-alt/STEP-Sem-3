public class WeeklyStaffPay {

    public abstract static class Staff {
        String name;

        public Staff(String name) {
            this.name = name;
        }

        public abstract double calculateWeeklyPay();
        public abstract String getRole();
    }

    public static class FullTimeStaff extends Staff {
        double fixedSalary;
        public FullTimeStaff(String name, double fixedSalary) {
            super(name);
            this.fixedSalary = fixedSalary;
        }
        @Override public double calculateWeeklyPay() { return fixedSalary; }
        @Override public String getRole() { return "Full-Time"; }
    }

    public static class HourlyStaff extends Staff {
        double hourlyRate;
        double hoursWorked;
        public HourlyStaff(String name, double hourlyRate, double hoursWorked) {
            super(name);
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }
        @Override
        public double calculateWeeklyPay() {
            if (hoursWorked <= 40) {
                return hoursWorked * hourlyRate;
            } else {
                return (40 * hourlyRate) + ((hoursWorked - 40) * hourlyRate * 1.5);
            }
        }
        @Override public String getRole() { return "Hourly"; }
    }

    public static class InternStaff extends Staff {
        double stipend;
        public InternStaff(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }
        @Override public double calculateWeeklyPay() { return stipend; }
        @Override public String getRole() { return "Intern"; }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Weekly Staff Pay ===");
        Staff[] staffList = {
            new FullTimeStaff("Ravi", 15000),
            new HourlyStaff("Asha", 300, 45), // 40*300 + 5*450 = 12000 + 2250 = 14250
            new InternStaff("Kiran", 5000)
        };

        double grandTotal = 0;
        for (Staff s : staffList) {
            double pay = s.calculateWeeklyPay();
            grandTotal += pay;
            System.out.printf("%s (%s): Rs %.2f%n", s.name, s.getRole(), pay);
        }
        System.out.printf("Total Weekly Payroll: Rs %.2f%n", grandTotal);
    }
}
