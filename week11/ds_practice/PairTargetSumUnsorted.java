import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairTargetSumUnsorted {

    public static int[] findPair(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println("=== DS P5: Pair With Target Sum (Unsorted) ===");
        int[] nums = {10, 15, 3, 7};
        int target = 17;
        System.out.println("Indices: " + Arrays.toString(findPair(nums, target)));
    }
}
