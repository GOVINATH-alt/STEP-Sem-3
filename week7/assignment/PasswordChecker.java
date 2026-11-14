public class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password != null ? password : "";
    }

    public String getStrength() {
        int len = password.length();
        if (len < 6) {
            return "Weak";
        } else if (len <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 3: The Password Checker ===");
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("pc1.getStrength() -> " + pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("pc2.getStrength() -> " + pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("pc3.getStrength() -> " + pc3.getStrength());
    }
}
