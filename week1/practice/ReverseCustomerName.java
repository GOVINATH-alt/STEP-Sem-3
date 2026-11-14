public class ReverseCustomerName {

    public static String reverseName(String name) {
        if (name == null) return null;
        char[] chars = name.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println("=== Customer Identity Verification System ===");
        String[] sampleNames = {"Alice Smith", "Govinath", "John Doe", "Robert"};
        for (String name : sampleNames) {
            String reversed = reverseName(name);
            System.out.printf("Original Name: \"%s\" -> Reversed: \"%s\"%n", name, reversed);
        }
    }
}
