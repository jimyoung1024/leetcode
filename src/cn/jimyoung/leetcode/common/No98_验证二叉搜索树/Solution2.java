package cn.jimyoung.leetcode.common.No98_验证二叉搜索树;

/**
 * 思路与Solution一致，都是中序遍历
 * 只不过这里使用pre这个变量来判断整个数组是否为单调上升
 * 就可以省去一个数组的空间
 */
public class Solution2 {
    long pre = Long.MIN_VALUE;//这个临时值取long是因为，如果第一个值就是Integer.MIN_VALUE会出错

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val <= pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}