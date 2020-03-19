package cn.jimyoung.leetcode.common.No409_LongestPalindrome;

public class LongestPlaindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[58];
        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }
        int res = 0;
        for (int i : count) {
            res += i % 2;
        }
        return res == 0 ? s.length() : (s.length() - res + 1);
    }
}
