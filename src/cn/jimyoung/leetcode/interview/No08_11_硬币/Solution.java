package cn.jimyoung.leetcode.interview.No08_11_硬币;

import java.util.HashSet;

public class Solution {
    public int waysToChange(int n) {
        int[] dp = new int[n + 1];
        int[] coins = new int[]{1, 5, 10, 25};
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < dp.length; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }
}
