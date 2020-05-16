package cn.jimyoung.leetcode.common.No560_和为K的子数组

class KotlinSolution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var res = 0
        for (i in nums.indices) {
            var temp = 0
            for (j in i..nums.lastIndex) {
                temp += nums[j]
                if (temp == k) {
                    res++
                }
            }
        }
        return res
    }
}
