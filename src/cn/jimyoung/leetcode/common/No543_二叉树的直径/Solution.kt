package cn.jimyoung.leetcode.common.No543_二叉树的直径

import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    var max: Int = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0
        recur(root)
        return max
    }

    fun recur(node: TreeNode?): Int {
        //if(node == null) return 0
        val left = recur(node?.left)
        val right = recur(node?.right)
        max = max(left + right + 1, max)
        return max(left, right) + 1
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    Solution().recur(null)
}