package cn.jimyoung.leetcode.common.No136_只出现一次的数字

class Solution {
    fun singleNumber(nums: IntArray): Int {
        var res = 0
        for (num in nums) {
            res = res xor num
        }
        return res
    }
}