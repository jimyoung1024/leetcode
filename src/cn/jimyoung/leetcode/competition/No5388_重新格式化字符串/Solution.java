package cn.jimyoung.leetcode.competition.No5388_重新格式化字符串;

import java.util.Stack;

/**
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 * <p>
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 * <p>
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 * <p>
 * 输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。 "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 * <p>
 * 输入：s = "leetcode"
 * 输出：""
 * 解释："leetcode" 中只有字母，所以无法满足重新格式化的条件。
 */
public class Solution {
    public String reformat(String s) {
        if (s.isEmpty()) return "";
        Stack<Character> numStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                charStack.push(c);
            } else if (Character.isDigit(c)) {
                numStack.push(c);
            } else {
                return null;
            }
        }
        StringBuilder res = new StringBuilder();
        if (Math.abs(numStack.size() - charStack.size()) > 1) {
            return "";
        } else {
            if (numStack.size() > charStack.size()) {
                res.append(numStack.pop());
                while (!numStack.isEmpty() || !charStack.isEmpty()) {
                    if (!charStack.isEmpty())
                        res.append(charStack.pop());
                    if (!numStack.isEmpty())
                        res.append(numStack.pop());
                }
            } else {
                res.append(charStack.pop());
                while (!numStack.isEmpty() || !charStack.isEmpty()) {
                    if (!numStack.isEmpty())
                        res.append(numStack.pop());
                    if (!charStack.isEmpty())
                        res.append(charStack.pop());
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String test = "j";
        System.out.println(new Solution().reformat(test));
    }
}
