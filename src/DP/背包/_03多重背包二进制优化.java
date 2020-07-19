package DP.背包;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author River
 * @date 2020/7/19 21:42
 * @description 输入
 * 4 5
 * 1 2 3
 * 2 4 1
 * 3 4 3
 * 4 5 2
 */
public class _03多重背包二进制优化 {

    static final int N = 2010;
    static final int M = 12010;
    static int[] v = new int[M]; //物品体积
    static int[] w = new int[M]; //物品价值

    static int[] f = new int[N];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //物品种类数量
        int m = sc.nextInt(); //背包的容积

        int cnt = 0;
        while (n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int s = sc.nextInt();
            int k = 1;
            //二进制划分物品
            while (s >= k) {
                cnt++;
                v[cnt] = k * a;
                w[cnt] = k * b;
                s -= k;
                k <<= 1;
            }

            if (s > 0) {
                cnt++;
                v[cnt] = s * a;
                w[cnt] = s * b;
            }

        }

        n = cnt; //新的物品数量

        //转化为了01背包问题
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i]; j--) {
                f[j] = Math.max(f[j], f[j - v[i]] + w[i]);
            }
        }

        System.out.println(f[m]);


    }
}
