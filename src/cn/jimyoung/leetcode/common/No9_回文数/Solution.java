package cn.jimyoung.leetcode.common.No9_回文数;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 你能不将整数转为字符串来解决这个问题吗？
 * <br/>
 * <a href="https://leetcode-cn.com/problems/palindrome-number/">题目链接</a>
 *
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int half = 0;
        //考虑输入一个0的情况
        while (x>=half){
            half = (half*10)+x%10;
            if(half == x || half == x/10) return true;
            x /=10;
        }
        return false;
    }

    public static void main(String[] args) {
        int test = 0;
        System.out.println(new Solution().isPalindrome(test));
    }
}
