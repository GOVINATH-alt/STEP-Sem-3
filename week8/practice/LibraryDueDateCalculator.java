import java.time.LocalDate;

public class LibraryDueDateCalculator {

    public abstract static class LibraryItem {
        String title;

        public LibraryItem(String title) {
            this.title = title;
        }

        public abstract int getBorrowDays();
        public LocalDate calculateDueDate(LocalDate borrowDate) {
            return borrowDate.plusDays(getBorrowDays());
        }
    }

    public static class Book extends LibraryItem {
        public Book(String title) { super(title); }
        @Override public int getBorrowDays() { return 14; }
    }

    public static class Magazine extends LibraryItem {
        public Magazine(String title) { super(title); }
        @Override public int getBorrowDays() { return 7; }
    }

    public static class DVD extends LibraryItem {
        public DVD(String title) { super(title); }
        @Override public int getBorrowDays() { return 3; }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Library Item Due Date Calculator ===");
        LocalDate today = LocalDate.of(2024, 2, 1);
        LibraryItem[] items = {
            new Book("Effective Java"),
            new Magazine("Tech Today"),
            new DVD("Inception")
        };

        for (LibraryItem item : items) {
            System.out.printf("Item: %-15s | Due Date: %s (%d days)%n",
                    item.title, item.calculateDueDate(today), item.getBorrowDays());
        }
    }
}
