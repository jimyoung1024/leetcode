package cn.jimyoung.leetcode.common.No279_完全平方数;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

/**
 * dp
 * 转移方程dp[i] = min(dp[i], dp[i-j*j]+1)
 */
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}
