package cn.jimyoung.leetcode.common.No530_二叉搜索树的最小绝对差

import kotlin.math.abs
import kotlin.math.min


class KotlinSolution2 {
    var minAbs = Int.MAX_VALUE
    var pre: Int? = null

    fun getMinimumDifference(root: TreeNode?): Int {
        inOrder(root)
        return minAbs
    }

    private fun inOrder(root: TreeNode?) {
        if (root == null) return
        inOrder(root.left)
        if (pre != null) {
            minAbs = min(abs(pre!! - root.`val`), minAbs)
        }
        pre = root.`val`
        inOrder(root.right)
    }

}