import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int runningSum = 0;

        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        for (int num : nums) {
            runningSum += num;
            if (prefixSumCount.containsKey(runningSum - k)) {
                count += prefixSumCount.get(runningSum - k);
            }
            prefixSumCount.put(runningSum, prefixSumCount.getOrDefault(runningSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 4: Subarray Sum Equals K ===");
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Input: " + Arrays.toString(nums1) + ", k = " + k1 + " -> Count: " + subarraySum(nums1, k1));

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Input: " + Arrays.toString(nums2) + ", k = " + k2 + " -> Count: " + subarraySum(nums2, k2));
    }
}
