package cn.jimyoung.leetcode.common.No530_二叉搜索树的最小绝对差

import kotlin.math.abs
import kotlin.math.min

/**
 * 凡是这种遍历树保存到数组的题，一定要想一下，能否使用一个临时变量替代数组
 * 这道题因为只是想计算像中序相邻节点的差，所以完全可以使用一个pre变量替代数组
 */
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    var minAbs = Int.MAX_VALUE
    var array = ArrayList<Int>()

    fun getMinimumDifference(root: TreeNode?): Int {
        treeToArray(root)
        for (i in 1..array.lastIndex) {
            minAbs = min(minAbs, abs(array[i] - array[i - 1]))
        }
        return minAbs
    }

    private fun treeToArray(root: TreeNode?) {
        if (root == null) return
        treeToArray(root.left)
        array.add(root.`val`)
        treeToArray(root.right)
    }
}