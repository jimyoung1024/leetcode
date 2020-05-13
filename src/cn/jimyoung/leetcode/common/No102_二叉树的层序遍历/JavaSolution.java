package cn.jimyoung.leetcode.common.No102_二叉树的层序遍历;

import cn.jimyoung.leetcode.util.java.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class JavaSolution {
    private final List<List<Integer>> levels = new ArrayList<>();

    //递归调用方法
    private void fun(TreeNode node, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.val);
        if (node.left != null) {
            fun(node.left, level + 1);
        }
        if (node.right != null) {
            fun(node.right, level + 1);
        }
    }

    //递归
    public List<List<Integer>> levelOrder_Rce(TreeNode root) {
        if (root == null) return new ArrayList<>();
        fun(root, 0);
        return levels;
    }

    //非递归
    public List<List<Integer>> levelOrder_NRce(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            res.add(new ArrayList<>());

            int resLength = queue.size();
            for (int i = 0; i < resLength; i++) {
                TreeNode node = queue.remove();

                res.get(level).add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }
        return res;
    }

}
