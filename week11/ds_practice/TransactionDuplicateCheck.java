import java.util.HashSet;
import java.util.Set;

public class TransactionDuplicateCheck {

    public static boolean hasDuplicateTransactions(String[] txIds) {
        Set<String> seen = new HashSet<>();
        for (String tx : txIds) {
            if (!seen.add(tx)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== DS P3: Transaction Duplicate Check ===");
        String[] batch1 = {"TX101", "TX102", "TX103", "TX101"};
        System.out.println("Batch 1 Duplicate: " + hasDuplicateTransactions(batch1));

        String[] batch2 = {"TX101", "TX102", "TX103"};
        System.out.println("Batch 2 Duplicate: " + hasDuplicateTransactions(batch2));
    }
}
