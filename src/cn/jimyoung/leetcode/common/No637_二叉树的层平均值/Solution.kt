package cn.jimyoung.leetcode.common.No637_二叉树的层平均值

import cn.jimyoung.leetcode.util.kotlin.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class Solution {
    fun averageOfLevels(root: TreeNode?): DoubleArray {
        if (root == null) return DoubleArray(0)
        val queue: Queue<TreeNode> = LinkedList()
        val res = ArrayList<Double>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val size = queue.size
            var sum = 0.0
            for (i in 1..size) {
                val node = queue.poll()
                sum += node.`val`
                if (node.left != null) queue.add(node.left)
                if (node.right != null) queue.add(node.right)
            }
            res.add(sum / size)
        }
        return res.toDoubleArray()
    }
}