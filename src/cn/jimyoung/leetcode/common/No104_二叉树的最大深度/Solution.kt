package cn.jimyoung.leetcode.common.No104_二叉树的最大深度

import cn.jimyoung.leetcode.util.kotlin.TreeNode
import kotlin.math.max

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}
