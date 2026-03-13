package _02_array;

import java.util.HashSet;

public class _02_Remove_Duplicates_In_Place_From_Sorted_Array {

    // TC - O(n)
    // SC - O(n)
    static int removeDuplicates_brute(int arr[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) {
            set.add(x);
        }

        int i = 0;
        for (int unique : set) {
            arr[i++] = unique;
        }
        
        return set.size();
    }

    // TC - O(n)
    // SC - O(1)
    static int removeDuplicates_optimal(int arr[]) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                arr[i+1] = arr[j];
                i++;
            }
        }

        return i+1;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 1, 2, 2, 3, 3};
        int arr2[] = {1, 1, 2, 2, 3, 3};
        System.out.println(removeDuplicates_brute(arr1));
        System.out.println(removeDuplicates_optimal(arr2));
    }
}
