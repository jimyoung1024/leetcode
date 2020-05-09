package cn.jimyoung.leetcode.common.No1351_统计有序矩阵中的负数

class Solution {
    fun countNegatives(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return 0
        var res = 0
        val len = grid[0].size
        for (arr in grid) {
            for ((i, num) in arr.withIndex()) {
                if (num < 0) {
                    res += (len - i)
                    break
                }
            }
        }
        return res
    }
}