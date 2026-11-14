public class FileExtensionValidator {

    public static String validateFileExtension(String filename) {
        if (filename == null) return "Rejected — invalid file type";

        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex == -1 || dotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String ext = filename.substring(dotIndex + 1);
        if (ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")) {
            return "Accepted";
        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== File Extension Validator ===");
        String[] tests = {"Assignment1.PDF", "notes.txt", "archive.ZIP", "report.docx", "sample"};
        for (String test : tests) {
            System.out.printf("Filename: \"%s\" -> %s%n", test, validateFileExtension(test));
        }
    }
}
