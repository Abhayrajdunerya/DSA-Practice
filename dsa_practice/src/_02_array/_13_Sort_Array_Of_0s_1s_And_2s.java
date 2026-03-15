package _02_array;

import java.util.Arrays;

import utils.Print;

public class _13_Sort_Array_Of_0s_1s_And_2s {

    // TC - O(n*log(n))
    // SC - O(1)
    static void sortArray_brute(int a[]) {
        Arrays.sort(a);
    }

    // TC - O(n)
    // SC - O(1)
    static void sortArray_optimal(int a[]) {
        int temp[] = new int[3];

        for (int i = 0; i < a.length; i++) {
            temp[a[i]]++;
        }

        int k = 0;
        int i = 0;
        while (k < temp.length) {
            while (temp[k] > 0) {
                if (k < a.length) {
                    a[i++] = k;
                    temp[k]--;
                }
            }
            k++;
        }
    }

    static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // TC - O(n)
    // SC - O(1)
    static void sortArray_optimal_dutch_national_flag_algo(int a[]) {
        int low = 0;
        int mid = 0;
        int high = a.length-1;

        while (mid < high) {
            if (a[mid] == 0) {
                swap(a, low, mid);
                low++;
                mid++;
            }
            if (a[mid] == 1) {
                mid++;
            }
            if (a[mid] == 2) {
                swap(a, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int a1[] = {2, 0, 2, 1, 1, 0};
        sortArray_brute(a1);
        Print.printArray(a1);
        
        int a2[] = {2, 0, 2, 1, 1, 0};
        sortArray_optimal(a2);
        Print.printArray(a2);

        int a3[] = {2, 0, 2, 1, 1, 0};
        sortArray_optimal_dutch_national_flag_algo(a3);
        Print.printArray(a3);
    }
}
