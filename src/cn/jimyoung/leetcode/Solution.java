package cn.jimyoung.leetcode;

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

/**
 * @author lijinyang
 */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        } else {
            while (pNode.next != null) {
                if (pNode.next.left == pNode) {
                    return pNode.next;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            Class<?> test = Class.forName("java.lang.String");
            System.out.println(test);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(Math.class.getClassLoader());
    }
}
