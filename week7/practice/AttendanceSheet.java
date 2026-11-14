public class AttendanceSheet {
    private final String[] presentStudents;
    private int count;

    public AttendanceSheet(int maxCapacity) {
        this.presentStudents = new String[maxCapacity];
        this.count = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            return; // Avoid duplicate entry
        }
        if (count < presentStudents.length) {
            presentStudents[count++] = name;
        }
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (presentStudents[i].equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public int getPresentCount() {
        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 5: The Attendance Sheet ===");
        AttendanceSheet sheet = new AttendanceSheet(50);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // Duplicate, ignored

        System.out.println("Present Count: " + sheet.getPresentCount());
        System.out.println("Is Ana present: " + sheet.isPresent("Ana"));
        System.out.println("Is Charlie present: " + sheet.isPresent("Charlie"));
    }
}
