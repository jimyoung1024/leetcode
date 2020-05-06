package cn.jimyoung.leetcode.common.No322_零钱兑换

import java.util.*

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 一个错误的解法，思路很简单，先拿大硬币，如果余额不足大硬币了再拿小硬币，知道余额为0
 * 这种解法，如果得到答案，硬币总数一定最小，但是有可能会得不到正确答案，
 * 例子：见main函数
 * 此题很有教学意义，所以这种错误解法就不删除了
 */
class KotlinSolution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        coins.sort()
        println(Arrays.toString(coins))
        var amountCopy = amount
        var res = 0
        var index = coins.lastIndex
        while (index >= 0) {
            val curCoin = coins[index]
            while (amountCopy >= curCoin) {
                println("$amountCopy\t$curCoin")
                amountCopy -= curCoin
                res++
            }
            index--
        }
        return if (amountCopy == 0) res else -1
    }
}

fun main() {
    println(KotlinSolution().coinChange(intArrayOf(186, 419, 83, 408), 6249))
}

