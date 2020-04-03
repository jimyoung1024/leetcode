package cn.jimyoung.leetcode.interview.No16_07_最大数值;

/**
 * @author Jimyoung
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 *
 * 此方法如果传入和返回的参数是long，只需将31全部更改为63即可
 */
public class Solution {
    public int maximum(int a, int b) {
        // 先考虑没有溢出时的情况，计算 b - a 的最高位，依照题目所给提示 k = 1 时 a > b，即 b - a 为负
        int k = b - a >>> 31;
        // 再考虑 a b 异号的情况，此时无脑选是正号的数字
        int aSign = a >>> 31, bSign = b >>> 31;
        // diff = 0 时同号，diff = 1 时异号
        int diff = aSign ^ bSign;
        // 在异号，即 diff = 1 时，使之前算出的 k 无效，只考虑两个数字的正负关系
        k = k & (diff ^ 1) | bSign & diff;
        //k == 1时a大， k==0 时b大
        return a * k + b * (k ^ 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximum(2147483647, 2147483647));
    }
}
