package cn.jimyoung.leetcode.common.No411_排列硬币;

public class Solution {
    public int arrangeCoins(int n) {
        return (int)(0.5+Math.sqrt(2*(long)n+0.25))-1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().arrangeCoins(1804289383));
    }
}
