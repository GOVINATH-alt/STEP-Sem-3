import java.util.Arrays;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 2: Maximum Subarray (Kadane's Algorithm) ===");
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: " + Arrays.toString(nums1) + " -> Max Subarray Sum: " + maxSubArray(nums1));

        int[] nums2 = {5, 4, -1, 7, 8};
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Max Subarray Sum: " + maxSubArray(nums2));
    }
}
