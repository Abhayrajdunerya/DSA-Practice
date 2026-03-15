package _02_array;

public class _15_Print_Subarray_With_Max_Sum_Kadanes_Algo {

    // Kadane's algo
    static long maxSubarraySum_optimal(int a[]) {
        int n = a.length;
        int maxSum = 0;

        int sum = 0;
        int start = 0;
        int ansStart = -1, ansEnd = -1;

        for (int i = 0; i < n; i++) {
            if (sum == 0) {
                start = i;
            }

            sum += a[i];
            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

            if (sum < 0) sum = 0;
        }

        // print sub array
        System.out.print("[ ");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("]");

        return maxSum;
    }
    public static void main(String[] args) {
        int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println(maxSubarraySum_optimal(a));
    }
}
