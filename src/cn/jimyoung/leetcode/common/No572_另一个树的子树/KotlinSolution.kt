package cn.jimyoung.leetcode.common.No572_另一个树的子树

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * 题目中明确说明，s，t不为空
 */
class Solution {
    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
        if(s == null) return false
        if(isSameTree(s, t)){
            return true
        }else{
            return isSubtree(s.left, t) || isSubtree(s.right, t)
        }
    }

    fun isSameTree(s: TreeNode?, t: TreeNode?): Boolean{
        if(s == null && t == null) return true
        if(s == null || t == null) return false
        if(s.`val` != t.`val`) return false
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right)
    }
}
