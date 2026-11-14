import java.util.ArrayList;
import java.util.List;

public class ClassReportCard {

    public static class Student {
        private String name;
        private int m1, m2, m3;
        private int total;
        private double average;
        private char grade;

        public Student(String name) {
            this.name = name;
        }

        public boolean setMarks(int a, int b, int c) {
            if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) {
                return false;
            }
            this.m1 = a;
            this.m2 = b;
            this.m3 = c;
            this.total = a + b + c;
            this.average = this.total / 3.0;

            if (average >= 80) grade = 'A';
            else if (average >= 70) grade = 'B';
            else if (average >= 60) grade = 'C';
            else if (average >= 40) grade = 'D';
            else grade = 'F';

            return true;
        }

        public int getTotal() { return total; }
        public String getName() { return name; }

        @Override
        public String toString() {
            return String.format("%s total=%d avg=%.2f grade=%c", name, total, average, grade);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Class Report Card ===");
        String[] rawNames = {"Asha", "Ravi", "Neha", "Kiran", "Pooja"};
        int[][] rawMarks = {
            {80, 90, 70},
            {60, 65, 70},
            {95, 85, 105}, // Invalid
            {45, 50, 40},
            {88, 72, 81}
        };

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < rawNames.length; i++) {
            Student s = new Student(rawNames[i]);
            if (!s.setMarks(rawMarks[i][0], rawMarks[i][1], rawMarks[i][2])) {
                System.out.println(rawNames[i] + " skipped: marks must be 0 to 100");
            } else {
                students.add(s);
            }
        }

        // Bubble sort descending by total with early exit
        int passes = 0;
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < n - 1 - i; j++) {
                if (students.get(j).getTotal() < students.get(j + 1).getTotal()) {
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.printf("%d. %s%n", (i + 1), students.get(i));
        }
        System.out.println("Sorted in " + passes + " passes");
    }
}
