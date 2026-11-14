public class CsvStudentRecordParser {

    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String roll = fields[1].trim();
        String dept = fields[2].trim();

        System.out.printf("Name: %s | Roll No: %s | Dept: %s%n", name, roll, dept);
    }

    public static void main(String[] args) {
        System.out.println("=== CSV Student Record Parser ===");
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");
    }
}
