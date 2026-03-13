package _01_maths;

public class Prime_Number_Check {

    // TC - O(n)
    // SC - O(n)
    static void primeCheck_brute(int n) {
        for (int i = 2; i < n; i++) {
            if (n%i == 0) {
                System.out.println("Not prime");
                return;
            }
        }
        System.out.println("Prime");
    }

    // TC - O(sqrt(n))
    // SC - O(1)
    static void primeCheck_optimal(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n%i == 0) {
                System.out.println("Not Prime");
                return;
            }
        }
        System.out.println("Prime");
    }

    public static void main(String[] args) {
        primeCheck_brute(1);
        primeCheck_brute(36);
        primeCheck_brute(7);
        System.err.println();

        primeCheck_optimal(1);
        primeCheck_optimal(36);
        primeCheck_optimal(7);
    }
}
