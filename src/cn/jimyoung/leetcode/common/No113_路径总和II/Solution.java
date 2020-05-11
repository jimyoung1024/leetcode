package cn.jimyoung.leetcode.common.No113_路径总和II;

import java.util.LinkedList;
import java.util.List;

class TreeNode_K {
    int val;
    TreeNode_K left;
    TreeNode_K right;
    TreeNode_K(int x) { val = x; }
}
public class Solution {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode_K root, int sum) {
        recur(root, sum, new LinkedList<>());
        return res;
    }
    private void recur(TreeNode_K node, int sum, List<Integer> list){
        if (node == null) return;
        sum -= node.val;
        list.add(node.val);
        if(node.left == null && node.right == null){
            if(sum == 0){
                res.add(new LinkedList<>(list));
            }
        }else {
            recur(node.left, sum, list);
            recur(node.right, sum, list);

        }
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode_K root = new TreeNode_K(5);
        root.left = new TreeNode_K(4);
        root.left.left = new TreeNode_K(11);
        root.left.left.left = new TreeNode_K(7);
        root.left.left.right = new TreeNode_K(2);
        root.right = new TreeNode_K(8);
        root.right.left = new TreeNode_K(13);
        root.right.right = new TreeNode_K(4);
        root.right.right.left = new TreeNode_K(5);
        root.right.right.right = new TreeNode_K(1);
        System.out.println(new Solution().pathSum(root, 22));
    }
}
