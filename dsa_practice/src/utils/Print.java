package utils;

public class Print {
    public static void printArray(int arr[]) {
        System.out.print("[");
        for (int x : arr) {
            System.out.print(" " + x + " ");
        }
        System.out.println("]");
    }
}
