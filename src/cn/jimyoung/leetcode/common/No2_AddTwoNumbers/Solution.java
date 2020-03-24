package cn.jimyoung.leetcode.common.No2_AddTwoNumbers;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode temp = this;
        while (temp != null) {
            s.append(temp.val);
            temp = temp.next;
        }
        return s.toString();
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;//进位
        ListNode head = new ListNode(0);
        ListNode result = head;
        int temp;
        while (l1 != null || l2 != null) {
            int n1 = (l1 == null) ? 0 : l1.val;
            int n2 = (l2 == null) ? 0 : l2.val;
            temp = n1 + n2 + c;
            c = temp / 10;
            result.next = new ListNode(temp % 10);
            result = result.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (c == 1) result.next = new ListNode(1);
        return head.next;
    }

}
