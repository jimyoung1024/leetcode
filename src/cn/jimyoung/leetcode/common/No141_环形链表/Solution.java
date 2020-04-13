package cn.jimyoung.leetcode.common.No141_环形链表;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            } else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return true;
    }
}
