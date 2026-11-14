import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvenOddListSeparator {

    public static void separateEvenOdd(int[] nums) {
        List<Integer> evens = new ArrayList<>();
        List<Integer> odds = new ArrayList<>();

        for (int n : nums) {
            if (n % 2 == 0) evens.add(n);
            else odds.add(n);
        }

        System.out.println("Original: " + Arrays.toString(nums));
        System.out.println("Evens:    " + evens);
        System.out.println("Odds:     " + odds);
    }

    public static void main(String[] args) {
        System.out.println("=== DS Practice 3: Even and Odd Numbers in a List ===");
        separateEvenOdd(new int[]{12, 17, 19, 24, 30, 33, 40});
    }
}
