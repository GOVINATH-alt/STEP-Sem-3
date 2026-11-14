public final class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.trim().split(" ");
        this.firstName = parts[0];
        this.lastName = parts.length > 1 ? parts[parts.length - 1] : "";
    }

    public String getNickname() {
        if (lastName.isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 3: The Nickname Tag (Immutable) ===");
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("tag.getNickname() -> " + tag.getNickname());
    }
}
