public class VowelConsonantCounterDS {

    public static void countVowelsConsonants(String word) {
        if (word == null) return;
        int vowels = 0, consonants = 0;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                if ("aeiou".indexOf(lower) != -1) vowels++;
                else consonants++;
            }
        }
        System.out.printf("Vowels: %d | Consonants: %d%n", vowels, consonants);
    }

    public static void main(String[] args) {
        System.out.println("=== DS Practice 1: Vowel and Consonant Counter ===");
        System.out.print("Word \"Programming\": ");
        countVowelsConsonants("Programming");
    }
}
