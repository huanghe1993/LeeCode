package 剑指offer;

import java.util.Arrays;

public class 剑指_Offer_17_打印从1到最大的n位数 {


    int[] res;
    int count = 0;

    public int[] printNumbers(int n) {
        res = new int[(int) Math.pow(10, n) - 1];
        count = 0;
        for (int i = 1; i < n + 1; i++) {
            for (char j = '1'; j <= '9'; j++) {
                char[] num = new char[i];
                num[0] = j;
                dfs(1, num, i);
            }
        }
        return res;
    }

    private void dfs(int index, char[] num, int digit) {
        if (index == digit) {
            res[count++] = Integer.parseInt(String.valueOf(num));
            return;
        }
        for (char i = '0'; i <= '9'; i++) {
            num[index] = i;
            dfs(index + 1, num, digit);
        }
    }

    public static void main(String[] args) {
        剑指_Offer_17_打印从1到最大的n位数 obj = new 剑指_Offer_17_打印从1到最大的n位数();
        int[] ints = obj.printNumbers(3);
        System.out.println(Arrays.toString(ints));
    }
}
