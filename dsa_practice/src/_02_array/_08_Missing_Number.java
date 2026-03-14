package _02_array;

public class _08_Missing_Number {

    // TC - O(n * N)
    // SC - O(1)
    static int missingNum_brute(int a[], int N) {
        for (int i = 1; i <= N; i++) {
            int flag = 0;
            for (int j = 0; j < a.length; j++) {
                if (i == a[j]) flag = 1;
            }
            if (flag == 0) return i;
        }
        
        return -1;
    }

    // TC - O(n + N)
    // SC - O(N)
    static int missingNum_better(int a[], int N) {
        int temp[] = new int[N+1];

        for (int i = 0; i < a.length; i++) {
            temp[a[i]]++;
        }

        for (int i = 1; i < N+1; i++) {
            if (temp[i] == 0) return i;
        }

        return -1;
    }

    // TC - O(n)
    // SC - O(1)
    static int missingNum_optimal(int a[], int N) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < a.length; i++) {
            xor2 = xor2 ^ a[i];
            xor1 = xor1 ^ (i+1);
        }

        xor1 = xor1 ^ N;
        int ans = xor1 ^ xor2;
        return ans != 0 ? ans : -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5};
        int N = 5;

        System.out.println(missingNum_brute(arr, N));
        System.out.println(missingNum_better(arr, N));
        System.out.println(missingNum_optimal(arr, N));
    }
}
