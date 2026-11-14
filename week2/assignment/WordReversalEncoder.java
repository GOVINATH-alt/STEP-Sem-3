public class WordReversalEncoder {

    public static String reverseEachWord(String sentence) {
        if (sentence == null) return null;
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            result.append(sb.reverse());
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("=== Word Reversal Encoder ===");
        String sample = "hello club";
        System.out.printf("Input: \"%s\" -> Output: \"%s\"%n", sample, reverseEachWord(sample));

        String sample2 = "Java programming is awesome";
        System.out.printf("Input: \"%s\" -> Output: \"%s\"%n", sample2, reverseEachWord(sample2));
    }
}
