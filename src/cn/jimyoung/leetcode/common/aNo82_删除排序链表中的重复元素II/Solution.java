package cn.jimyoung.leetcode.common.aNo82_删除排序链表中的重复元素II;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = new ListNode(-1);
        ListNode fast = head;
        while (fast.next != null) {
            ListNode pre = fast;
            fast = fast.next;
            if (fast.val > pre.val) {
                slow.next = fast;
            }
        }
        return null;
    }
}
