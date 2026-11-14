import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static char findFirstNonRepeatingChar(String input) {
        if (input == null || input.isEmpty()) {
            return '\0';
        }

        int[] freq = new int[256];
        for (int i = 0; i < input.length(); i++) {
            freq[input.charAt(i)]++;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (freq[c] == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void test(String s) {
        char ch = findFirstNonRepeatingChar(s);
        if (ch != '\0') {
            System.out.printf("Input: \"%s\" -> First non-repeating character: '%c'%n", s, ch);
        } else {
            System.out.printf("Input: \"%s\" -> No non-repeating character found.%n", s);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Unique Letter Hunt Mini-Game ===");
        test("stress");
        test("teeter");
        test("swiss");
        test("aabbcc");
    }
}
