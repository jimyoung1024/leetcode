package cn.jimyoung.leetcode.common.No138_复制带随机指针的链表;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    HashMap<Node, Node> visitedHash = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (visitedHash.containsKey(head)) {
            return visitedHash.get(head);
        }
        Node node = new Node(head.val);
        visitedHash.put(head, node);
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        return node;
    }
}
