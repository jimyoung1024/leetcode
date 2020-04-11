package cn.jimyoung.leetcode.common.No151_翻转字符串里的单词;

import java.util.*;

public class Solution {
    public String reverseWords(String s) {
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list).trim();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("the! sky    is! blue"));
    }
}
