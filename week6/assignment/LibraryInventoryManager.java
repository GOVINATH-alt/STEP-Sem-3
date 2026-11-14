public class LibraryInventoryManager {

    public static class BookRecord {
        String title;
        String author;
        int copiesAvailable;

        public BookRecord(String title, String author, int copiesAvailable) {
            this.title = title;
            this.author = author;
            this.copiesAvailable = copiesAvailable;
        }

        public void printRecord() {
            System.out.printf("\"%s\" by %s | Copies: %d%n", title, author, copiesAvailable);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment M1: Library Inventory Management ===");
        BookRecord[] inventory = {
            new BookRecord("Clean Code", "Robert C. Martin", 5),
            new BookRecord("Effective Java", "Joshua Bloch", 3),
            new BookRecord("Introduction to Algorithms", "CLRS", 7)
        };

        for (BookRecord b : inventory) {
            b.printRecord();
        }
    }
}
