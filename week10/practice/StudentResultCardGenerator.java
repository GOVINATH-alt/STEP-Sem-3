public class StudentResultCardGenerator {

    public static void generateResultCard(String name, int[] marks) {
        int total = 0;
        for (int m : marks) total += m;
        double avg = (double) total / marks.length;

        char grade;
        if (avg >= 85) grade = 'A';
        else if (avg >= 70) grade = 'B';
        else if (avg >= 50) grade = 'C';
        else grade = 'D';

        System.out.println("=================================");
        System.out.println("       STUDENT RESULT CARD       ");
        System.out.println("=================================");
        System.out.println("Name: " + name);
        System.out.println("Subjects: " + marks.length);
        System.out.println("Total Marks: " + total);
        System.out.printf("Average: %.2f%%%n", avg);
        System.out.println("Grade: " + grade);
        System.out.println("=================================");
    }

    public static void main(String[] args) {
        System.out.println("=== DS Practice 10: Student Result Card Generator ===");
        generateResultCard("Govinath", new int[]{85, 92, 78, 88, 95});
    }
}
