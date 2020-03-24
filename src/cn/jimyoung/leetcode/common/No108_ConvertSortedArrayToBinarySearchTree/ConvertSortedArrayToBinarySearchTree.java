package cn.jimyoung.leetcode.common.No108_ConvertSortedArrayToBinarySearchTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ConvertSortedArrayToBinarySearchTree {

    private TreeNode fun(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = fun(nums, left, mid - 1);
        root.right = fun(nums, mid + 1, right);

        return root;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return fun(nums, 0, nums.length - 1);
    }
}
