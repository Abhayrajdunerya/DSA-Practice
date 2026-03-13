package _01_maths;

public class Prime_Number_Print {

    // TC - O(n^2)
    // SC - O(1)
    static void printPrime_brute(int n) {
        for (int i = 1; i <= n; i++) {
            int j;
            for (j = 2; j < i; j++) {
                if (i%j == 0) break;
            }
            if (j == i) System.out.print(i + " ");
        }
    }

    static void printPrime_better(int n) {
        for (int i = 2; i <= n; i++) {
            int j;
            for (j = 2; j*j < i; j++) {
                if (i%j == 0) break;
            }
            if (j*j > i) System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        // printPrime_brute(100);
        printPrime_better(100);
    }
}
