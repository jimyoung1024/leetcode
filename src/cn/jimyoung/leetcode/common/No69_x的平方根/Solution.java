package cn.jimyoung.leetcode.common.No69_x的平方根;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 */
public class Solution {
    public int mySqrt(int x) {
        if(x<=1) return x;
        double x0 = 1;
        double x1 = (x0+x/x0)/2.0;
        while (Math.abs(x0-x1)>=1){
            x0=x1;
            x1 = (x0+x/x0)/2.0;
        }
        return (int)x1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(3));
    }
}
