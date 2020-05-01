package cn.jimyoung.leetcode.common.No21_合并两个有序链表;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * 与归并排序思路类似，但是有一个优化的点
 * 当第一个主while循环结束后，可以直接有剩余当那个条链表直接接上，不用一个节点一个节点接
 * 为什么迭代算法效率会不如递归算法呢？
 * <p>
 * 这段代码LeetCode执行时间1ms， 内存消耗39.7MB 分别超越100%和38.32%
 * 递归那段代码LeetCode执行时间 0ms, 内训消耗39.8MB 分别超越68.93%和44.86%
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);//头结点，简化操作
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return head.next;
    }
}
