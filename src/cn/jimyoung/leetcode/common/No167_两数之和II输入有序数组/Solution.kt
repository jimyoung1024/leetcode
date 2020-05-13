package cn.jimyoung.leetcode.common.No167_两数之和II输入有序数组

//    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
//    函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
//    这个下标是从1开始计数的
class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var index1 = 0
        var index2 = numbers.size - 1
        while (index1 < index2) {
            val temp = numbers[index1] + numbers[index2]
            when {
                temp > target -> index2--
                temp < target -> index1++
                temp == target -> return intArrayOf(index1 + 1, index2 + 1)
            }
        }
        //按照题意，不会达到下面这行
        return IntArray(0)
    }
}