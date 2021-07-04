package 每日一题;

public class 剑指offer_15_二进制中的1 {

    public int hammingWeight(int n) {
        // 巧妙的利用了 n与n-1的n&(n-1)的关系
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }

}
