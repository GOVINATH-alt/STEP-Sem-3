public class LibraryLateFineCounter {

    public abstract static class LibraryItem {
        String title;
        int daysLate;

        public LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        public abstract double calculateFine();
        public abstract String getItemType();
    }

    public static class BookItem extends LibraryItem {
        public BookItem(String title, int daysLate) { super(title, daysLate); }
        @Override public double calculateFine() { return daysLate * 2.0; } // Rs 2/day
        @Override public String getItemType() { return "Book"; }
    }

    public static class DvdItem extends LibraryItem {
        public DvdItem(String title, int daysLate) { super(title, daysLate); }
        @Override public double calculateFine() { return daysLate * 5.0; } // Rs 5/day
        @Override public String getItemType() { return "DVD"; }
    }

    public static class MagazineItem extends LibraryItem {
        public MagazineItem(String title, int daysLate) { super(title, daysLate); }
        @Override public double calculateFine() { return daysLate * 1.0; } // Rs 1/day
        @Override public String getItemType() { return "Magazine"; }
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: Library Late Fine Counter ===");
        LibraryItem[] items = {
            new BookItem("Algorithms Unlocked", 5),
            new DvdItem("Interstellar", 3),
            new MagazineItem("National Geographic", 4)
        };

        double totalFine = 0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            totalFine += fine;
            System.out.printf("%-10s \"%-22s\" (%d days late) -> Fine: Rs %.2f%n",
                    item.getItemType(), item.title, item.daysLate, fine);
        }
        System.out.printf("Total Fines Collected: Rs %.2f%n", totalFine);
    }
}
