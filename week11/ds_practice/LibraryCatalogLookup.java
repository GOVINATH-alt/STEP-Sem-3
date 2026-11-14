public class LibraryCatalogLookup {

    public static class BookRecord {
        String isbn;
        String title;
        public BookRecord(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    public static String findBook(BookRecord[] catalog, String targetIsbn) {
        int low = 0, high = catalog.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = catalog[mid].isbn.compareTo(targetIsbn);
            if (cmp == 0) return catalog[mid].title;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return "Book Not Found";
    }

    public static void main(String[] args) {
        System.out.println("=== DS P1: Library Catalog Lookup (Binary Search) ===");
        BookRecord[] catalog = {
            new BookRecord("9780134685991", "Effective Java"),
            new BookRecord("9780262033848", "Introduction to Algorithms"),
            new BookRecord("9780596009205", "Head First Java")
        };
        System.out.println("Search 9780262033848: " + findBook(catalog, "9780262033848"));
        System.out.println("Search 9781111111111: " + findBook(catalog, "9781111111111"));
    }
}
