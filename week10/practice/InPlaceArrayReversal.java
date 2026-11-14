import java.util.Arrays;

public class InPlaceArrayReversal {

    public static void reverseInPlace(int[] arr) {
        if (arr == null) return;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== DS Practice 4: In-Place Array Reversal ===");
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Before: " + Arrays.toString(arr));
        reverseInPlace(arr);
        System.out.println("After:  " + Arrays.toString(arr));
    }
}
