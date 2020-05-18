package cn.jimyoung.leetcode.common.No152_乘积最大子数组

import kotlin.math.max
import kotlin.math.min

/*
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
class Solution {
    fun maxProduct(nums: IntArray): Int {
        var max = nums[0]
        var min = nums[0]
        var res = nums[0]
        for (i in 1..nums.lastIndex) {
            val maxCopy = max
            val minCopy = min
            max = max(max(nums[i], maxCopy * nums[i]), minCopy * nums[i])
            min = min(min(nums[i], maxCopy * nums[i]), minCopy * nums[i])
            res = max(res, max)
        }
        return res
    }
}