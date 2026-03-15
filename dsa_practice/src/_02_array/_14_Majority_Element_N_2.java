package _02_array;

import java.util.HashMap;

public class _14_Majority_Element_N_2 {

    // TC - O(n^2)
    // SC - O(1)
    static int majorityElement_brute(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) cnt++;
            }
            if (cnt > n/2) return a[i];
        }

        return -1;
    }

    // TC - O(n)
    // SC - O(n)
    static int majorityElement_better(int a[]) {
        int n = a.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : a) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x)+1);
            } else {
                map.put(x, 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) > n/2) return key;
        }

        return -1;
    }

    // Moore's voting algorithm
    static int majorityElement_optimal(int a[]) {
        int n = a.length;
        int ele = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                ele = a[i];
                cnt = 1;
            } else if (a[i] == ele) cnt++;
            else cnt --;
        }

        int eleCnt = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == ele) eleCnt++;
        }

        if (eleCnt > n/2) return ele;
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {2, 2, 3, 3, 1, 2, 2};
        System.out.println(majorityElement_brute(a));
        System.out.println(majorityElement_better(a));
        System.out.println(majorityElement_optimal(a));
    }
}
