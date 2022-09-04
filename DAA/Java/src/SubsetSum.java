import java.util.Arrays;
import java.util.Scanner;

public class Subset {
    static int[] arr;
    static boolean[] bool;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the length of the array and Elements one by one");
        int n = s.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = s.nextInt();
        Arrays.sort(arr);
        System.out.println("Enter the target sum");
        int sum = s.nextInt();
        bool = new boolean[n];
        System.out.println("All possible combinations are :");

        subsetSum(sum, n - 1);
    }

    static void subsetSum(int req, int i) {
        if (i < 0 && req != 0) return;
        if (i < 0) {print(); return;}

        if (req >= arr[i] && !bool[i]) {
            bool[i] = true;
            subsetSum(req - arr[i], i - 1);
            bool[i] = false;
            subsetSum(req, i - 1);
        } else {
            bool[i] = false;
            subsetSum(req, i - 1);
        }

    }

    static void print() {
        for (int i = 0; i < arr.length; i++) {
            if (bool[i]) System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
