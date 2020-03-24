package cn.jimyoung.leetcode.common.No445AddTwoNumbers_2;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    int flow = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res1 = l1, res2 = l2;
        int len1 = 0, len2 = 0;
        for (; l1 != null; l1 = l1.next) len1++;
        for (; l2 != null; l2 = l2.next) len2++;
        ListNode res = len1 > len2 ? add(res1, res2, len1, len2) : add(res2, res1, len2, len1);
        if (flow == 1) {
            res1 = new ListNode(1);
            res1.next = res;
            return res1;
        }
        return res;
    }

    public ListNode add(ListNode l1, ListNode l2, int len1, int len2) {
        ListNode temp = new ListNode(0);
        if ((len1 == 1) && (len2 == 1)) {
            temp.val = (l1.val + l2.val) % 10;
            flow = (l1.val + l2.val) / 10;
            return temp;
        } else if (len1 > len2) {
            temp.next = add(l1.next, l2, len1 - 1, len2);
            temp.val = (l1.val + flow) % 10;
            flow = (l1.val + flow) / 10;
            return temp;
        } else {
            temp.next = add(l1.next, l2.next, len1 - 1, len2 - 1);
            temp.val = (l1.val + l2.val + flow) % 10;
            flow = (l1.val + l2.val + flow) / 10;
            return temp;
        }
    }
}
