package cn.jimyoung.leetcode.interview.No04_04_检查平衡性

import kotlin.math.abs
import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true
        if (abs(treeHeight(root.left) - treeHeight(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right)
        } else {
            return false
        }
    }

    fun treeHeight(node: TreeNode?): Int {
        if (node == null) return 0
        return max(treeHeight(node.left), treeHeight(node.right)) + 1
    }
}

fun main() {
    val root = TreeNode(3)
    root.left = TreeNode(9)
    root.right = TreeNode(20)
    root.right!!.left= TreeNode(15)
    root.right!!.right = TreeNode(7)
    println(Solution().isBalanced(root))
}