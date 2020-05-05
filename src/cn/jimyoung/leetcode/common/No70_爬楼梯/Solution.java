package cn.jimyoung.leetcode.common.No70_爬楼梯;

public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return n;//防止输入n = 1导致错误
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(45));
    }
}
