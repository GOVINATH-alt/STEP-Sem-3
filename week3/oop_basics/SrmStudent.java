public class SrmStudent {
    private String name;
    private String regNo;
    private double cgpa;
    private int libraryBooks;

    private static String university = "SRM Institute of Science and Technology";
    private static String campus = "SRM Kattankulathur";
    private static int admissionCount = 0;

    public SrmStudent(String name, String regNo, double cgpa) {
        this.name = name;
        this.regNo = regNo;
        this.cgpa = cgpa;
        this.libraryBooks = 0;
        admissionCount++;
    }

    public void issueBook() {
        this.libraryBooks++;
    }

    public void displayStudent() {
        System.out.printf("Student: %s | Reg: %s | CGPA: %.2f | Books Issued: %d | Uni: %s | Campus: %s%n",
                name, regNo, cgpa, libraryBooks, university, campus);
    }

    public static int getTotalAdmissions() {
        return admissionCount;
    }

    public static void main(String[] args) {
        System.out.println("=== Week 3 OOP Classes & Objects: Student Model ===");
        SrmStudent s1 = new SrmStudent("Ravi Kumar", "RA2311003010001", 8.85);
        SrmStudent s2 = new SrmStudent("Pooja Sharma", "RA2311003010002", 9.12);

        s1.issueBook();
        s1.issueBook();
        s2.issueBook();

        s1.displayStudent();
        s2.displayStudent();
        System.out.println("Total Admissions Registered: " + SrmStudent.getTotalAdmissions());
    }
}
