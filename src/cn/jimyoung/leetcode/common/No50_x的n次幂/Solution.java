package cn.jimyoung.leetcode.common.No50_x的n次幂;

/**
 * 最原始的暴力解法就不写了
 * 这里是递归解法，思路如下
 * 如果n为奇数，return x * myPow(x, n-1);
 * 如果n为偶数，return myPow(x, n/2) * myPow(x, n/2);
 */
public class Solution {
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
        //下面这步非常关键，减少了非常多的递归操作
        double temp = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return x * temp * temp;
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(new Solution().myPow(2, Integer.MIN_VALUE));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        System.out.println(-Integer.MAX_VALUE);
    }
}
