public class TypingAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            System.out.println("Invalid input strings.");
            return;
        }

        int total = original.length();
        int compareLen = Math.min(original.length(), typed.length());
        int matched = 0;
        int firstMismatchPos = -1;
        char origChar = '\0', typedChar = '\0';

        for (int i = 0; i < compareLen; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1; // 1-based index
                origChar = original.charAt(i);
                typedChar = typed.charAt(i);
            }
        }

        if (firstMismatchPos == -1 && original.length() != typed.length()) {
            firstMismatchPos = compareLen + 1;
            origChar = compareLen < original.length() ? original.charAt(compareLen) : ' ';
            typedChar = compareLen < typed.length() ? typed.charAt(compareLen) : ' ';
        }

        double accuracy = (matched * 100.0) / total;
        if (firstMismatchPos == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matched, total, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matched, total, accuracy, firstMismatchPos, origChar, typedChar);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Typing Speed Test Accuracy Checker ===");
        System.out.print("Sample 1: ");
        checkTypingAccuracy("hello world", "hello worlt");

        System.out.print("Sample 2: ");
        checkTypingAccuracy("coding", "coding");
    }
}
