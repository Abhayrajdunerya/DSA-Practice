package _02_array;

import java.util.Arrays;
import java.util.HashMap;

public class _12_Two_Sum {

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public void setFirst(int first) {
            setFirst(first);
        }

        public void setSecond(int second) {
            setSecond(second);
        }

        static void print(Pair pair) {
            System.out.println("{first: " + pair.first + ", second: " + pair.second + "}");
        }
    }

    // TC - O(n^2)
    // SC - O(1)
    static Pair twoSum_brute(int a[], int target) {
        int n = a.length;
        Pair pair = new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && (a[i] + a[j]) == target) return new Pair(a[i], a[j]);
            }
        }

        return pair;
    }

    // TC - O(n) or O(nLog(n))
    // SC - O(n)
    static Pair twoSum_better(int a[], int target) {
        int n = a.length;
        Pair pair = new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int rem = target - a[i];
            if (map.containsKey(rem)) return new Pair(rem, a[i]);
            else map.put(a[i], i);
        }

        return pair;
    }

    // TC - O(n)
    // SC - O(1)
    static Pair twoSum_optimal(int a[], int target) {
        int n = a.length;
        Pair pair = new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Arrays.sort(a);

        int left = 0, right = n-1;
        while (left < right) {
            if (a[left] + a[right] < target) left++;
            else if (a[left] + a[right] > target) right--;
            else return new Pair(a[left], a[right]);
        }

        return pair;
    }

    public static void main(String[] args) {
        int a[] = { 2, 6, 5, 8, 11 };
        int target = 14;
        Pair.print(twoSum_brute(a, target));
        Pair.print(twoSum_better(a, target));
        Pair.print(twoSum_optimal(a, target));
    }
}
