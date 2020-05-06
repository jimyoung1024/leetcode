package cn.jimyoung.leetcode.common.No983_最低票价

import kotlin.math.min

class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val lastDay = days.last()
        val dp = IntArray(lastDay + 1)
        var pos = 0;
        for (i in 1..lastDay) {
            if (i == days[pos]) {
                val day1 = i - 1
                val day7 = if (i - 7 > 0) i - 7 else 0
                val day30 = if (i - 30 > 0) i - 30 else 0
                dp[i] = min(min(dp[day1] + costs[0], dp[day7] + costs[1]), dp[day30] + costs[2])
                pos++
            } else {
                dp[i] = dp[i - 1]
            }
        }
        return dp[lastDay]
    }
}