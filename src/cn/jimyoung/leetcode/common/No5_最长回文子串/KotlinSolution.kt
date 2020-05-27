package cn.jimyoung.leetcode.common.No5_最长回文子串

/*
 * dp算法
 * 转移方程：
 * 边界：dp[i][i] = true          dp[i][i+1] = (s[i] == s[i+1])
 * dp[i][j] = (dp[i+1][j-1] && s[i] == s[j])
 */
class KotlinSolution {
    fun longestPalindrome(s: String): String {
        val len = s.length
        if (len < 2) return s
        val dp = Array(len) { BooleanArray(len) { false } }
        var begin = 0
        var maxLen = 1
        for (j in 0 until len) {
            for (i in 0..j) {
                if (i == j) {
                    dp[i][j] = true
                } else if (i == j - 1) {
                    dp[i][j] = s[i] == s[j]
                    if (dp[i][j] && maxLen < j - i + 1) {
                        maxLen = j - i + 1
                        begin = i
                    }
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && s[i] == s[j]
                    if (dp[i][j] && maxLen < j - i + 1) {
                        maxLen = j - i + 1
                        begin = i
                    }
                }
            }
        }
        return s.substring(begin,begin+maxLen)
    }
}
