import java.util.*;

public class FilteredWordFrequency {

    private static final Set<String> STOP_WORDS = new HashSet<>(
            Arrays.asList("the", "was", "and", "a", "is", "of", "in")
    );

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No feedback provided.");
            return;
        }

        // Normalize: lowercase, strip punctuation
        String normalized = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "");

        String[] tokens = normalized.trim().split("\\s+");
        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : tokens) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Sort by frequency descending
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Stop-Word-Filtered Word Frequency Report ===");
        String sample = "The mentor was great, the session was great and clear.";
        System.out.println("Input: \"" + sample + "\"");
        System.out.println("Output:");
        printFilteredWordFrequency(sample);
    }
}
