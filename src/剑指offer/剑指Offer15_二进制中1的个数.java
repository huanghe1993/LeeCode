package 剑指offer;

public class 剑指Offer15_二进制中1的个数 {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }
}
