package _02_array;

import java.util.HashMap;

public class _10_Find_No_That_Appears_Once_And_Other_Twice {

    // TC - O(n^2)
    // SC - O(1)
    static int getSingleElement_brute(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) cnt++;
            }
            if (cnt < 2) return i;
        }

        return -1;
    }

    // TC - O(n)
    // SC - O((n/2)+1)
    static int getSingleElement_better(int a[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : a) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) < 2) return key;
        }

        return -1;
    }

    // TC - O(n)
    // SC - O(1)
    static int getSingleElement_optimal(int a[]) {
        int xor = 0;
        for (int x : a) {
            xor = xor ^ x;
        }

        return xor;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 3, 3, 4, 4};
        System.out.println(getSingleElement_brute(arr));
        System.out.println(getSingleElement_better(arr));
        System.out.println(getSingleElement_optimal(arr));
    }
}
