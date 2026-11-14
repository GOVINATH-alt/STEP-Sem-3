public class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            System.out.println("Combination successfully updated for Locker #" + lockerNumber);
            return true;
        } else {
            System.out.println("Incorrect current code. Combination change rejected for Locker #" + lockerNumber);
            return false;
        }
    }

    public boolean unlock(String code) {
        return this.combinationCode.equals(code);
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 4: The Locker Code ===");
        Locker locker = new Locker(101, "1234");
        locker.changeCode("0000", "5678"); // Rejected
        locker.changeCode("1234", "5678"); // Succeeded
        System.out.println("Unlock with 5678: " + locker.unlock("5678"));
    }
}
