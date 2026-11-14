public class LibraryIdCardManager {

    public static class IdCard {
        String name;
        int booksIssued;

        public IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== M4: Library ID Card Reference Management ===");
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi; // Points to identical object in memory
        duplicate.booksIssued = 3;

        System.out.println("Ravi's booksIssued (via ravi): " + ravi.booksIssued);
        System.out.println("ravi == duplicate: " + (ravi == duplicate));

        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("ravi == separate (different objects): " + (ravi == separate));
    }
}
