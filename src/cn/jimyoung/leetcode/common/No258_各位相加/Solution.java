package cn.jimyoung.leetcode.common.No258_各位相加;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 */
public class Solution {
    public int addDigits(int num) {
        int res = 0;
        do {
            res = 0;
            while (num > 0) {
                res += num % 10;
                num /= 10;
            }
            num = res;
        }while (res>=10);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addDigits(38));
    }
}
