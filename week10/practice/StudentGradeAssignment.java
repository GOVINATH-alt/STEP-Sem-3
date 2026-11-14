public class StudentGradeAssignment {

    public static char getGrade(int marks) {
        if (marks >= 90) return 'A';
        if (marks >= 80) return 'B';
        if (marks >= 70) return 'C';
        if (marks >= 60) return 'D';
        return 'F';
    }

    public static void main(String[] args) {
        System.out.println("=== DS Practice 8: Student Grade Assignment ===");
        int[] scores = {95, 82, 74, 61, 45};
        for (int s : scores) {
            System.out.printf("Score: %d -> Grade: %c%n", s, getGrade(s));
        }
    }
}
