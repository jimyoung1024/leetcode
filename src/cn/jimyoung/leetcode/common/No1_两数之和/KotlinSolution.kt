package cn.jimyoung.leetcode.common.No1_两数之和

import kotlin.collections.HashMap


class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        //key = num, value = index
        val map = HashMap<Int, Int>()
        for ((index, num) in nums.withIndex()) {
            if (map.containsKey(target - num)) {
                return intArrayOf(map[target - num]!!, index)
            }
            map[num] = index
        }
        return IntArray(2)
    }
}

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val res = (Solution().twoSum(nums, 9))
    println(res.contentToString())
}


