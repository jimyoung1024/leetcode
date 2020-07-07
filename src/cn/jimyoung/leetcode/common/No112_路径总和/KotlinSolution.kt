package cn.jimyoung.leetcode.common.No112_路径总和

import cn.jimyoung.leetcode.util.kotlin.TreeNode


class Solution {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        if (root == null) {
            return false
        }
        val temp = sum - root.`val`
        if(root.left == null && root.right == null){
            return temp == 0
        }
        return hasPathSum(root.left, temp) || hasPathSum(root.right, temp)
    }
}