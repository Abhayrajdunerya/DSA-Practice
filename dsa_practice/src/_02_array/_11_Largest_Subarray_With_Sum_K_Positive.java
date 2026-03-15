package _02_array;

import java.util.HashMap;

public class _11_Largest_Subarray_With_Sum_K_Positive {

    // TC - O(n^2)
    // SC - O(1)
    static int longestSubarrayWithSumK_brute(int a[], int k) {
        int n = a.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum == k) maxLen = Math.max(maxLen, j-i+1);
            }
        }

        return maxLen;
    }

    // TC - O(n) or O(nlog(n))
    // SC - O(n)
    static int longestSubarrayWithSumK_better(int a[], int k) {
        int n = a.length;
        int maxLen = 0;

        long sum = 0;
        HashMap<Long, Integer> preSumMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (sum == k) maxLen = Math.max(maxLen, i+1);

            long rem = sum - k;
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
    }

    // TC - O(2n)
    // SC - O(1)
    static int longestSubarrayWithSumK_optimal(int a[], int k) {
        int n = a.length;
        int maxLen = 0;

        int left = 0, right = 0;
        long sum = a[0];

        while (right < n) {
            while (sum > k) {
                sum -= a[left];
                left++;
            }

            if (sum == k) maxLen = Math.max(maxLen, right-left+1);

            right++;
            if (right < n) sum += a[right];
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
        int k = 3;
        System.out.println(longestSubarrayWithSumK_brute(a, k));
        System.out.println(longestSubarrayWithSumK_better(a, k));
        System.out.println(longestSubarrayWithSumK_optimal(a, k));
    }
}
