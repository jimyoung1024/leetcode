package cn.jimyoung.leetcode.common.No560_和为K的子数组

class KotlinSolution2 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        val map = HashMap<Int, Int>()
        var pre = 0
        map[0] = 1
        for (num in nums) {
            pre += num
            val temp = pre - k
            if (map.containsKey(temp)) {
                count += map[temp]!!
            }
            map[pre] = map.getOrDefault(pre, 0) + 1
        }
        return count
    }
}

fun main() {
    val test = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    println(KotlinSolution2().subarraySum(test, 0))
}