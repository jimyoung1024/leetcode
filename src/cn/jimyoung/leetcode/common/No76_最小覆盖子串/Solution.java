package cn.jimyoung.leetcode.common.No76_最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-window-substring/">题目链接<a/>
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 */
public class Solution {
    public String minWindow(String s, String t) {
        if ("".equals(s) || "".equals(t)) return "";
        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
            if (t.contains(String.valueOf(s.charAt(i)))) {
                count++;
                if (count == t.length()) {
                    int left = Integer.MAX_VALUE;
                    for (int j = 0; j < t.length(); j++) {
                        left = Math.min(left, map.get(t.charAt(j)));
                    }
                    return s.substring(left, i + 1);
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new Solution().minWindow(s, t));
    }
}
