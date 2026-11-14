public class PalindromeChecker {

    public static boolean isPalindromeIterative(String text) {
        if (text == null) return false;
        String s = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text == null) return false;
        String s = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return checkRecursiveHelper(s, 0, s.length() - 1);
    }

    private static boolean checkRecursiveHelper(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return checkRecursiveHelper(s, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        if (text == null) return false;
        String s = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        char[] original = s.toCharArray();
        char[] reversed = new char[original.length];
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void verifyPalindrome(String text) {
        boolean it = isPalindromeIterative(text);
        boolean rec = isPalindromeRecursive(text);
        boolean arr = isPalindromeArrayReversal(text);

        System.out.printf("\"%s\" -> Iterative: %s | Recursive: %s | Array Reversal: %s%n",
                text,
                it ? "Palindrome" : "Not Palindrome",
                rec ? "Palindrome" : "Not Palindrome",
                arr ? "Palindrome" : "Not Palindrome");
    }

    public static void main(String[] args) {
        System.out.println("=== Palindrome Checker (3 Approaches) ===");
        verifyPalindrome("madam");
        verifyPalindrome("hello");
        verifyPalindrome("racecar");
        verifyPalindrome("A man, a plan, a canal: Panama");
    }
}
