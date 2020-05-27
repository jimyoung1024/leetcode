package cn.jimyoung.leetcode.common.No516_最长回文子序列

class Solution {
    fun longestPalindromeSubseq(s: String): Int {
        val len = s.length
        if (len < 2) return len
        val dp = Array(len) { IntArray(len) { 1 } }
        var maxLen = 1
        for (j in 0 until len) {
            for (i in 0..j) {
                if (i == j) {
                    dp[i][j] = 1
                } else if (i == j - 1) {
                    if (s[i] == s[j]){
                        dp[i][j] = 2
                    }else{
                        dp[i][j] = 1
                    }

                    if (dp[i][j] && maxLen < j - i + 1) {
                        maxLen = j - i + 1
                    }
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
                    if (dp[i][j] && maxLen < j - i + 1) {
                        maxLen = j - i + 1
                    }
                }
            }
        }

    }
}