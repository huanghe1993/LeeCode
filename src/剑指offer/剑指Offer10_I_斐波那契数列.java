package 剑指offer;

public class 剑指Offer10_I_斐波那契数列 {

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int fib1 = 0;
        int fib2 = 1;
        for (int i = 2; i <= n; i++) {
            int fib3 = (fib1 + fib2)% 1000000007;
            fib1 = fib2;
            fib2 = fib3;
        }
        return fib2;

    }

    public int fib2(int n) {
        if(n < 2) return n;
        long[] result = new long[n + 1];
        result[0] = 0;
        result[1] = 1;
        for(int i = 2; i <= n; i++){
            result[i] = result[i - 1] + result[i - 2];
            result[i] %= (Math.pow(10,9) +7);
        }
        return (int)result[n];

    }


    public static void main(String[] args) {
        剑指Offer10_I_斐波那契数列 obj = new 剑指Offer10_I_斐波那契数列();
        int fib = obj.fib(48);
        int fib2 = obj.fib2(48);
        System.out.println(fib);
        System.out.println(fib2);
    }
}
