import java.util.Arrays;

public class PairSumSortedArray {

    public static int[] pairSumSorted(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1}; // 1-based
            else if (sum < target) left++;
            else right--;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println("=== DS P9: Pair Sum in Sorted Array (Two Pointers) ===");
        int[] arr = {2, 7, 11, 15};
        System.out.println("1-based indices for target 9: " + Arrays.toString(pairSumSorted(arr, 9)));
    }
}
