import java.util.Arrays;

public class DutyRosterRotation {

    public static String[] rotateRoster(String[] names, int k) {
        if (names == null || names.length == 0) return names;
        int n = names.length;
        k = (int) (k % n);
        if (k == 0) return names;

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        System.out.println("=== Assignment Problem 8: Duty Roster Rotation ===");
        String[] roster = {"A", "B", "C", "D", "E"};
        System.out.println("Original: " + Arrays.toString(roster));
        System.out.println("Rotated (k=2): " + Arrays.toString(rotateRoster(roster, 2)));
        System.out.println("Rotated (k=7): " + Arrays.toString(rotateRoster(roster, 7)));
    }
}
