package cn.jimyoung.leetcode.common.No322_零钱兑换

import kotlin.math.min


class KotlinSolution2 {
    private lateinit var coinsInClass: IntArray
    var ans = Int.MAX_VALUE
    fun coinChange(coins: IntArray, amount: Int): Int {
        coinsInClass = coins.sortedArray()
        dfs(coinsInClass.lastIndex, amount, 0)
        return if (ans == Int.MAX_VALUE) -1 else ans
    }

    fun dfs(index: Int, amount: Int, cnt: Int) {
        if (index < 0) return
        val c = amount / coinsInClass[index]
        for (i in c downTo 0) {
            val na = amount - i * coinsInClass[index]
            val cntTemp = cnt + i
            if (na == 0) {
                ans = min(ans, cntTemp)
                break
            }
            if (cntTemp + 1 >= ans) {
                break
            }
            dfs(index - 1, na, cntTemp)
        }
    }
}

fun main() {
    val coins = intArrayOf(1, 2, 5)
    println(KotlinSolution2().coinChange(coins, 11))
}