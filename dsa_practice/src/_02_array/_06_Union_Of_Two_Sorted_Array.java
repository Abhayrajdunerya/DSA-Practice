package _02_array;

import java.util.ArrayList;
import java.util.HashSet;

public class _06_Union_Of_Two_Sorted_Array {

    // TC - O(n+m)
    // SC - (n+m)
    static ArrayList<Integer> union_brute(int arr1[], int arr2[]) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr1)
            set.add(x);
        for (int x : arr2)
            set.add(x);

        ArrayList<Integer> unionList = new ArrayList<>();

        for (int x : set) {
            unionList.add(x);
        }

        return unionList;
    }

    // TC - O(n1 + n2)
    // SC - O(1)
    static ArrayList<Integer> union_optimal(int a[], int b[]) {
        int n1 = a.length;
        int n2 = b.length;

        int i = 0, j = 0;

        ArrayList<Integer> union = new ArrayList<>();

        while (i < n1 && j < n2) {
            if (a[i] <= b[j]) {
                if (union.size() == 0 || union.get(union.size() - 1) != a[i]) {
                    union.add(a[i]);
                }
                i++;
            } else {
                if (union.size() == 0 || union.get(union.size() - 1) != b[j]) {
                    union.add(b[j]);
                }
                j++;
            }
        }

        while (i < n1) {
            if (union.size() == 0 || union.get(union.size() - 1) != a[i]) {
                union.add(a[i]);
            }
            i++;
        }

        while (j < n2) {
            if (union.size() == 0 || union.get(union.size() - 1) != b[j]) {
                union.add(b[j]);
            }
            j++;
        }

        return union;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 1, 2, 3, 4, 5 };
        int arr2[] = { 2, 3, 4, 4, 5, 6, 7, 8 };
        System.out.println(union_brute(arr1, arr2));
        System.out.println(union_optimal(arr1, arr2));
    }
}
