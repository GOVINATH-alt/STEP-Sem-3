public class TeamDuplicateChecker {

    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null || teamNames.length == 0) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("=== Problem 2: Team Name Duplicate Checker ===");
        String[] t1 = {"ByteForce", "CodeCrafters", "NullPointers", "ByteForce"};
        System.out.println("Batch 1: " + findDuplicateTeam(t1));

        String[] t2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println("Batch 2: " + findDuplicateTeam(t2));
    }
}
