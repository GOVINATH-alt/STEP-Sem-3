public class WordReverserPalindrome {

    public static boolean checkPalindrome(String s) {
        if (s == null) return false;
        String clean = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== DS Practice 2: Word Reverser & Palindrome Checker ===");
        System.out.println("level -> " + (checkPalindrome("level") ? "Palindrome" : "Not Palindrome"));
        System.out.println("world -> " + (checkPalindrome("world") ? "Palindrome" : "Not Palindrome"));
    }
}
