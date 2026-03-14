package _02_array;

import utils.Print;

public class _04_Left_Rotate_The_Array_By_D_Places {

    // TC - O(n)
    // SC - O(d)
    static void leftRotate_brute(int arr[], int d) {
        if (d == 0) return;
        int n = arr.length;
        d = d%n;

        int temp[] = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        
        for (int i = d; i < n; i++) {
            arr[i-d] = arr[i];
        }

        for (int i = n-d; i < n; i++) {
            arr[i] = temp[i-(n-d)];
        }
    }

    static void reverse(int arr[], int start, int end) {
        int n = arr.length;
        if (start < 0 || end < 0 || start >= n || end >= n) return;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // TC - O(n)
    // SC - O(1)
    static void leftRotate_optimal(int arr[], int d) {
        int n = arr.length;
        d = d%n;

        reverse(arr, 0, d-1);
        reverse(arr, d, n-1);
        reverse(arr, 0, n-1);
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5, 6, 7};
        int arr2[] = {1, 2, 3, 4, 5, 6, 7};
        int d = 3;
        leftRotate_brute(arr1, d);
        leftRotate_optimal(arr2, d);
        Print.printArray(arr1);
        Print.printArray(arr2);
    }
}
