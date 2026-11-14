import java.util.Arrays;

public class FindMinRotatedSortedArray {

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 5: Find Minimum in Rotated Sorted Array ===");
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums1) + " -> Minimum: " + findMin(nums1));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Input: " + Arrays.toString(nums2) + " -> Minimum: " + findMin(nums2));
    }
}
