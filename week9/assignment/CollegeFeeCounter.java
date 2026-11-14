public class CollegeFeeCounter {

    public interface TransportFacility {
        double getBusFee();
    }

    public abstract static class Student {
        String name;
        double baseTuition;

        public Student(String name, double baseTuition) {
            this.name = name;
            this.baseTuition = baseTuition;
        }

        public abstract double calculateTotalFee();
        public abstract String getCategory();
    }

    public static class DayScholar extends Student implements TransportFacility {
        public DayScholar(String name, double tuition) { super(name, tuition); }
        @Override public double getBusFee() { return 15000.0; }
        @Override public double calculateTotalFee() { return baseTuition + getBusFee(); }
        @Override public String getCategory() { return "Day Scholar"; }
    }

    public static class Hosteller extends Student {
        double hostelAndMessFee;
        public Hosteller(String name, double tuition, double hostelFee) {
            super(name, tuition);
            this.hostelAndMessFee = hostelFee;
        }
        @Override public double calculateTotalFee() { return baseTuition + hostelAndMessFee; }
        @Override public String getCategory() { return "Hosteller"; }
    }

    public static class ScholarshipStudent extends Student implements TransportFacility {
        double scholarshipAmount;
        public ScholarshipStudent(String name, double tuition, double scholarship) {
            super(name, tuition);
            this.scholarshipAmount = scholarship;
        }
        @Override public double getBusFee() { return 15000.0; }
        @Override public double calculateTotalFee() { return Math.max(0, baseTuition - scholarshipAmount) + getBusFee(); }
        @Override public String getCategory() { return "Scholarship"; }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 3: College Fee Counter ===");
        Student[] students = {
            new DayScholar("Arun", 75000),
            new Hosteller("Divya", 75000, 45000),
            new ScholarshipStudent("Karan", 75000, 30000)
        };

        for (Student s : students) {
            System.out.printf("%-8s (%-12s): Total Fee = Rs %.2f%n", s.name, s.getCategory(), s.calculateTotalFee());
        }
    }
}
