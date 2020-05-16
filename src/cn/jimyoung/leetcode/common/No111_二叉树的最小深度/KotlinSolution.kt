package cn.jimyoung.leetcode.common.No111_二叉树的最小深度

import cn.jimyoung.leetcode.util.kotlin.TreeNode
import kotlin.math.min


class Solution {
    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0

        if (root.left == null) return minDepth(root.right) + 1
        if (root.right == null) return minDepth(root.left) + 1
        return min(minDepth(root.left), minDepth(root.right)) + 1
    }
}