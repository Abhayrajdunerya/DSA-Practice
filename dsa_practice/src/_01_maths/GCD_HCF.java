package _01_maths;

public class GCD_HCF {

    // Euclidean Algo
    static int gcd_hcf(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) a = a%b;
            else b = b%a;
        }

        if (a == 0) return b;
        return a;
    }
    public static void main(String[] args) {
        System.out.println(gcd_hcf(9, 12));
        System.out.println(gcd_hcf(52, 10));
    }
}
