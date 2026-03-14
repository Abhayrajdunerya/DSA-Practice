package _02_array;

public class _09_Max_Consecutive_Ones {

    // TC - O(n)
    // SC - O(1)
    static int maxConsecutiveOnes_optimal(int a[]) {
        int max = 0;
        int cnt = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                cnt++;
                max = Math.max(max, cnt);
            } else cnt = 0;
        }

        return max;
    }
    public static void main(String[] args) {
        int a[] = {1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1};
        System.out.println(maxConsecutiveOnes_optimal(a));
    }
}
