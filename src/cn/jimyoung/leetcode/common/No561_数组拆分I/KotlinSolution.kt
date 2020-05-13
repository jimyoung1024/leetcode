package cn.jimyoung.leetcode.common.No561_数组拆分I

import kotlin.math.min

/**
 * 题目确保输入的数组大小为偶数
 */
class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        var res = 0
        nums.sort()
        for (i in 0 until nums.lastIndex step 2) {
            res += min(nums[i], nums[i + 1])
        }
        return res
    }
}