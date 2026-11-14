public class StudentCollegeInfoManager {

    public static class Student {
        String name;
        String rollNumber;

        static String collegeName = "SRM University";
        static int studentCount = 0;

        public Student(String name, String rollNumber) {
            this.name = name;
            this.rollNumber = rollNumber;
            studentCount++;
        }

        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Total Students Enrolled: " + studentCount);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== M5: Student & College Info (Static vs Instance) ===");
        new Student("Asha", "RA01");
        new Student("Kiran", "RA02");
        new Student("Pooja", "RA03");

        Student.printCollegeInfo();
    }
}
