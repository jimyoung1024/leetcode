package cn.jimyoung.leetcode.common.No53_最大子序列和

import kotlin.math.max

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var dp = nums[0]
        var res = nums[0]
        for (i in 1 until nums.size) {
            dp = max(nums[i], dp + nums[i])
            res = max(res, dp)
        }
        return res
    }
}