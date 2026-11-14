public class BankTransactionValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String reference) {
        if (reference == null || reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        // First 3 chars must be letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Remaining 11 chars must be digits
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain 11 digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String day = reference.substring(3, 5);
        String month = reference.substring(5, 7);
        String year = reference.substring(7, 9);
        String seq = reference.substring(9, 14);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(day).append("/").append(month).append("/").append(year)
          .append(" | SEQ: ").append(seq);
        return sb.toString();
    }

    public static void process(String raw) {
        String normalized = normalizeReference(raw);
        String result = validateAndFormat(normalized);
        System.out.printf("Raw: \"%s\" -> %s%n", raw, result);
    }

    public static void main(String[] args) {
        System.out.println("=== Bank Transaction Reference Validator ===");
        process("  hdf03022600042  ");
        process("12F03022600042");
        process("sbi03022600123");
    }
}
