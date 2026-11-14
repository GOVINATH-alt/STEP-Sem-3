public class FactorialCalculation {

    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers not supported.");
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("=== DS Practice 7: Factorial Calculation ===");
        for (int i = 0; i <= 10; i++) {
            System.out.printf("%2d! = %d%n", i, factorial(i));
        }
    }
}
