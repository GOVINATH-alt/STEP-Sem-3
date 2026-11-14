public class DuplicatePlayerPickChecker {

    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length == 0) {
            return "No Duplicates Found";
        }

        // Nested loops without Collections
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment 2: Duplicate Player Pick Checker ===");
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println("Lineup 1: " + findDuplicatePick(lineup1));

        String[] lineup2 = {"Kohli", "Bumrah", "Gill", "Rohit"};
        System.out.println("Lineup 2: " + findDuplicatePick(lineup2));
    }
}
