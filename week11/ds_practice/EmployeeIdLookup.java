public class EmployeeIdLookup {

    public static int linearSearchId(int[] ids, int targetId) {
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == targetId) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("=== DS P4: Employee ID Lookup in Unsorted Directory ===");
        int[] directory = {1045, 2031, 1098, 4055, 3012};
        System.out.println("Search 4055: index " + linearSearchId(directory, 4055));
        System.out.println("Search 9999: index " + linearSearchId(directory, 9999));
    }
}
