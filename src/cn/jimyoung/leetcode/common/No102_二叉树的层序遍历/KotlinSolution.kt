package cn.jimyoung.leetcode.common.No102_二叉树的层序遍历

import cn.jimyoung.leetcode.util.kotlin.TreeNode
import java.util.*
import kotlin.collections.ArrayList

class KotlinSolution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val res = ArrayList<List<Int>>()
        if (root == null) return res
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            var size = queue.size
            val tempList = ArrayList<Int>()
            while (size > 0) {
                val tempNode = queue.poll()
                tempList.add(tempNode.`val`)
                if (tempNode.left != null) queue.add(tempNode.left)
                if (tempNode.right != null) queue.add(tempNode.right)
                size--
            }
            res.add(tempList)
        }
        return res
    }
}