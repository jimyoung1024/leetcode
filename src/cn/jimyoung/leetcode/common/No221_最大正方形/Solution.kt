package cn.jimyoung.leetcode.common.No221_最大正方形

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val m = matrix.size
        if (m == 0) return 0
        var res = 0
        val n = matrix[0].size
        //不得不吐槽一下Kotlin二维数组的创建方式，沿用[][]风格不好嘛
        val dp = Array(m + 1) { IntArray(n + 1) { 0 } }
        for (i in 0..matrix.lastIndex) {
            for (j in 0..matrix[0].lastIndex) {
                if (matrix[i][j] == '1') {
                    var temp = min(dp[i][j], dp[i][j + 1])
                    temp = min(temp, dp[i + 1][j])
                    dp[i + 1][j + 1] = 1 + temp
                    res = max(dp[i + 1][j + 1], res)
                }
            }
        }
        return res * res
    }
}