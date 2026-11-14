import java.util.Arrays;

public class RemoveDuplicatesSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int writeIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[writeIndex++] = nums[i];
            }
        }
        return writeIndex;
    }

    public static void main(String[] args) {
        System.out.println("=== DS P10: Remove Duplicates from Sorted Array In-Place ===");
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};
        System.out.println("Original: " + Arrays.toString(nums));
        int k = removeDuplicates(nums);
        System.out.println("Unique count: " + k);
        System.out.print("Array after deduplication: [");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + (i < k - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
