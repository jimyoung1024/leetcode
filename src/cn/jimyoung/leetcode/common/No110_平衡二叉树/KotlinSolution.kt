package cn.jimyoung.leetcode.common.No110_平衡二叉树

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        return recur(root) != -1
    }

    fun recur(node: TreeNode?): Int {
        if (node == null) return 0
        val left = recur(node.left)
        if (left == -1) return -1
        val right = recur(node.right)
        if (right == -1) return -1
        return if (Math.abs(left - right) < 2) Math.max(left, right) + 1 else -1
    }
}
