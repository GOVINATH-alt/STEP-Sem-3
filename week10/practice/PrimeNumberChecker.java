public class PrimeNumberChecker {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== DS Practice 6: Prime Number Checker ===");
        int[] tests = {2, 17, 25, 29, 49, 97};
        for (int t : tests) {
            System.out.printf("%d is %s%n", t, isPrime(t) ? "Prime" : "Not Prime");
        }
    }
}
