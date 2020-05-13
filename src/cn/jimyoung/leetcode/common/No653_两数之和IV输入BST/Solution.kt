package cn.jimyoung.leetcode.common.No653_两数之和IV输入BST

import cn.jimyoung.leetcode.util.kotlin.TreeNode

class Solution {
    val set = HashSet<Int>()
    fun findTarget(root: TreeNode?, k: Int): Boolean {
        return helper(root, k)
    }

    private fun helper(node: TreeNode?, k: Int): Boolean {
        if (node == null) return false
        return if (set.contains(k - node.`val`)) {
            true
        } else {
            set.add(node.`val`)
            helper(node.left, k) || helper(node.right, k)
        }
    }
}