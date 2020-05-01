package cn.jimyoung.leetcode.common.No50_x的n次幂;

/**
 * 循环解法，这个解法运用了二进制的思想
 */
public class Solution2 {

    public double myPow(double x, int n) {
        if (n == 0 || Math.abs(x - 1.0) < 1e-6) return 1.0;
        if ((long) n < 0) {
            return fastPow(1 / x, -(long) n);
        } else {
            return fastPow(x, n);
        }
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        double res = 1.0;
        while (n > 0) {
            if ((n & 1) == 1)
                res *= x;
            x *= x;
            n = n >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(new Solution2().myPow(2, Integer.MIN_VALUE));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}
