package _02_array;

import utils.Print;

public class _05_Move_All_Zeros_To_The_End_Of_The_Array {

    // TC - O(2n)
    // SC - O(n)
    static void moveZeroEnd_brute(int arr[]) {
        int n = arr.length;
        int temp[] = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                temp[k++] = arr[i];
            }
        }

        for (int i = 0; i < k; i++) {
            arr[i] = temp[i];
            if (i + k < n) arr[i+k] = 0;
        }
    }

    // TC - O(n)
    // SC - O(1)
    static void moveZeroEnd_optimal(int arr[]) {
        int n = arr.length;
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }

        if (j == -1) return;

        for (int i = j+1; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int arr1[] = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        int arr2[] = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        moveZeroEnd_brute(arr1);
        moveZeroEnd_optimal(arr2);
        Print.printArray(arr1);
        Print.printArray(arr2);
    }
}
