package DP;

/**
 * @author River
 * @date 2020/7/12 21:33
 * @description
 */
public class ArraySum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 7, 8, 3};
        int opt = new ArraySum().rec_opt(arr, arr.length - 1);
        int opt2 = new ArraySum().dp_opt(arr);
        System.out.println(opt);
        System.out.println(opt2);
        System.out.println(1);
    }

    public int rec_opt(int[] arr, int i) {
        if (i == 0) {
            return arr[0];
        } else if (i == 1) {
            return Math.max(arr[0], arr[1]);
        } else {
            int A = rec_opt(arr, i - 2) + arr[i];
            int B = rec_opt(arr, i - 1);
            return Math.max(A, B);
        }
    }

    public int dp_opt(int[] arr) {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            int A = opt[i - 2] + arr[i];
            int B = opt[i - 1];
            opt[i] = Math.max(A, B);
        }
        return opt[arr.length - 1];
    }
}
