package cn.jimyoung.leetcode.common.No155_最小栈;

import java.util.Stack;

/**
 * 利用链表，每个Node有一个叫 min 的值，记录的是他和他之前入栈节点的value的最小值
 */
public class MinStack2 {

    Node head;

    /**
     * initialize your data structure here.
     */
    public MinStack2() {
        head = new Node(0, null);
    }

    public void push(int x) {
        if(head.next == null){
            head.next = new Node(x, null, x);
        }else {
            head.next = new Node(x, head.next, Math.min(x, head.next.min));
        }
    }

    public void pop() {
        head.next = head.next.next;
    }

    public int top() {
        return head.next.value;
    }

    public int getMin() {
        return head.next.min;
    }

    static class Node{
        int value;
        Node next;
        int min;

        public Node(int value, Node next, int min) {
            this.value = value;
            this.next = next;
            this.min = min;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }

}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */