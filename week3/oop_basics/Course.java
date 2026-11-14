public class Course {
    private String courseCode;
    private String title;
    private int credits;
    private int maxCapacity;
    private int enrolled;

    public Course(String courseCode, String title, int credits, int maxCapacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.credits = credits;
        this.maxCapacity = maxCapacity;
        this.enrolled = 0;
    }

    public boolean enrollStudent() {
        if (enrolled < maxCapacity) {
            enrolled++;
            return true;
        }
        return false;
    }

    public void displayCourseInfo() {
        System.out.printf("Course [%s] %s | Credits: %d | Enrolled: %d/%d%n",
                courseCode, title, credits, enrolled, maxCapacity);
    }

    public static void main(String[] args) {
        System.out.println("=== Week 3 OOP Classes & Objects: Course Model ===");
        Course dsa = new Course("21CSC201J", "Data Structures and Algorithms", 4, 60);
        dsa.enrollStudent();
        dsa.enrollStudent();
        dsa.displayCourseInfo();
    }
}
