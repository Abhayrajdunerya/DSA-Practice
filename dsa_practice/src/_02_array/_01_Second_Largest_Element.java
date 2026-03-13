package _02_array;

import java.util.Arrays;

public class _01_Second_Largest_Element {

    // TC - O(2n)
    // SC - O(1)
    static int brute(int arr[]) {
        int n = arr.length;

        // 1. find largest element
        int largest = arr[0];
        for (int i = 0; i < n; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // 2. find second largest
        int sLargest = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < largest) {
                sLargest = Math.max(sLargest, arr[i]);
            }
        }

        return sLargest;
    }

    // TC - O(nlog(n))
    // SC - O(1)
    static int better(int arr[]) {
        int n = arr.length;
        if (n < 2) return Integer.MIN_VALUE;
        Arrays.sort(arr);

        int largest = arr[n-1];
        int i = n-1;
        while (i >= 0 && arr[i] == largest) {
            i--;
        }

        if (i >= 0) return arr[i];
        return Integer.MIN_VALUE;
    }

    // TC - O(n)
    // SC - O)(1)
    static int optimal(int arr[]) {
        int largest = arr[0];
        int sLargest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                sLargest = largest;
                largest = arr[i];
            } else if (arr[i] > sLargest && arr[i] < largest) {
                sLargest = arr[i];
            }
        }

        return sLargest;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 7, 7, 5};
        System.out.println(brute(arr));
        System.out.println(better(arr));
        System.out.println(optimal(arr));
    }
}
