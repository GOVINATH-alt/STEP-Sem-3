import java.util.Arrays;

public class LibraryBookShelfInsertionSort {

    public static void shelf(int[] books) {
        if (books == null || books.length == 0) return;
        int n = books.length;

        for (int i = 1; i < n; i++) {
            int key = books[i];
            int j = i - 1;
            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;
            System.out.printf("After placing %d: %s%n", key, Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: The Library Book Shelf (Insertion Sort) ===");
        int[] b = {30, 10, 40, 20};
        System.out.println("Input: " + Arrays.toString(b));
        shelf(b);
    }
}
