package cn.jimyoung.leetcode.common.No23_合并K个排序链表;

import com.sun.org.apache.bcel.internal.generic.LNEG;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) queue.add(list);
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (!queue.isEmpty()) {
            temp.next = queue.poll();
            temp = temp.next;
            if (temp.next != null) queue.add(temp.next);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(-2);
        a1.next = new ListNode(-1);
        a1.next.next = new ListNode(-1);
        a1.next.next.next = new ListNode(-1);

        ListNode a2 = null;

        ListNode[] test = {a1, null};
        ListNode res = new Solution().mergeKLists(test);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }
}
