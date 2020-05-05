package cn.jimyoung.leetcode.common.No83_删除排序链表中的重复元素;

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
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null) {
            ListNode pre = fast;
            fast = fast.next;
            if (fast.val > pre.val) {
                slow.next = fast;
                slow = fast;
            }
        }
        slow.next = null;
        return head;
    }
}
