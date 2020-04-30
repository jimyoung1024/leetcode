package cn.jimyoung.leetcode.common.No155_最小栈;

import java.util.Stack;

/**
 * 自己想的方法，用一个Stack + 一个minValue记录最小值
 */
public class MinStack {

    Stack<Integer> stack;
    int minValue = Integer.MAX_VALUE;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        minValue = Math.min(minValue, x);
    }

    public void pop() {
        stack.pop();
        minValue = Integer.MAX_VALUE;
        for (Integer integer : stack) {
            minValue = Math.min(minValue, integer);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
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