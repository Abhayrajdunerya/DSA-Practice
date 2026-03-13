package _01_maths;

public class Find_All_Factors {

    // TC - O(n)
    // SC - O(1)
    static void printAllFactors_brute(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }

    // TC - O(sqrt(n))
    // SC - O(1)
    static void printAllFactors_optimal(int n) {
        for (int i = 1; i*i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
                if (n/i != i) System.out.println(n/i);
            }
        }
    }

    public static void main(String[] args) {
        // printAllFactors_brute(36);
        printAllFactors_optimal(36);
    }
}
