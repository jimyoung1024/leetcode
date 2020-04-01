package cn.jimyoung.leetcode.common.No20_有效的括号;

import java.util.Stack;

/**
 * @author lijinyang
 */
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '{' || temp == '[') {
                stack.push(temp);
            } else if (temp == ')' || temp == '}' || temp == ']') {
                //此时判断栈是否为空是为了解决输入为"]"这种情况
                if (stack.empty()) return false;
                char left = stack.pop();
                switch (left) {
                    case '(':
                        if (temp != ')') return false;
                        break;
                    case '[':
                        if (temp != ']') return false;
                        break;
                    case '{':
                        if (temp != '}') return false;
                        break;
                    default:
                        System.out.println("Error");
                }
            }
        }
        if (stack.empty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("([)]"));
    }
}
