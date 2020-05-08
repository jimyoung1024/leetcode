package cn.jimyoung.leetcode.common.No1277_统计全为1的正方形子矩阵

import kotlin.math.min

class Solution {
    fun countSquares(matrix: Array<IntArray>): Int {
        val m = matrix.size
        if (m == 0) return 0
        var res = 0
        val n = matrix[0].size
        val dp = Array(m + 1) { IntArray(n + 1) { 0 } }
        for (i in 1..m) {
            for (j in 1..n) {
                if (matrix[i - 1][j - 1] == 1) {
                    var temp = min(dp[i - 1][j], dp[i][j - 1])
                    temp = min(temp, dp[i - 1][j - 1])
                    dp[i][j] = 1 + temp
                    res += dp[i][j]
                }
            }
        }
        return res
    }
}