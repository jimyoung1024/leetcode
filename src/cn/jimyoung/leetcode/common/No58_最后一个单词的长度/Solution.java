package cn.jimyoung.leetcode.common.No58_最后一个单词的长度;

public class Solution {
    public int lengthOfLastWord(String s) {
        String sWithoutBlank = s.trim();
        return sWithoutBlank.length() - sWithoutBlank.lastIndexOf(' ') - 1;
    }

    public static void main(String[] args) {
        String test = "a";
        System.out.println(new Solution().lengthOfLastWord(test));
    }
}
