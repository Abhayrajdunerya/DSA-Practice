package _02_array;

import java.util.ArrayList;

public class _07_Intersection_Of_Two_Sorted_Array {

    // TC - O(n*m)
    // SC - O(1)
    static ArrayList<Integer> intersection_brute(int a[], int b[]) {
        int n1 = a.length;
        int n2 = b.length;
        ArrayList<Integer> intersection = new ArrayList<>();

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (a[i] == b[j]) {
                    if (intersection.size() == 0 || intersection.get(intersection.size()-1) != a[i]) {
                        intersection.add(a[i]);
                    }
                }
            }
        }

        return intersection;
    }

    // TC - O(n+m)
    // SC - O(1)
    static ArrayList<Integer> intersection_optimal(int a[], int b[]) {
        int n1 = a.length;
        int n2 = b.length;
        ArrayList<Integer> intersection = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n1 && j < n2) {
            if (a[i] < b[j]) i++;
            else if (a[i] > b[j]) j++;
            else {
                if (intersection.size() == 0 || intersection.get(intersection.size()-1) != a[i]) {
                    intersection.add(a[i]);
                }
                i++;
                j++;
            }
        }

        return intersection;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 2, 3, 3, 4, 5, 6};
        int b[] = {2, 3, 3, 5, 6, 6, 7};
        System.out.println(intersection_brute(a, b));
        System.out.println(intersection_optimal(a, b));
    }
}
