import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Contains Duplicate ===");
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(Arrays.toString(nums1) + " -> " + containsDuplicate(nums1));

        int[] nums2 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(nums2) + " -> " + containsDuplicate(nums2));
    }
}
