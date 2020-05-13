package cn.jimyoung.leetcode.common.No107_二叉树的层次遍历II

import cn.jimyoung.leetcode.util.kotlin.TreeNode
import java.util.*
import kotlin.collections.ArrayList

/**
 * 这题完全可以直接采用No102里的方法，然后反转最后的结果数组
 * 这样的话，这道题就是失去了意义
 */
class Solution {
    val res = LinkedList<MutableList<Int>>()
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        helper(root, 0)
        res.reverse()
        return res
    }

    private fun helper(node: TreeNode?, level: Int) {
        if (node == null) return
        if (level >= res.size) {
            res.add(ArrayList())
        }
        res[level].add(node.`val`)
        if (node.left != null) helper(node.left, level + 1)
        if (node.right != null) helper(node.right, level + 1)
    }
}