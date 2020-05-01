package cn.jimyoung.leetcode.common.No3_无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口解决问题
 * 在这道题的解法里，left是左指针，i是右指针
 * map内保存当前窗口内的字符，根据的key的唯一性，只要不断的put就可以保证窗口中字符的唯一性
 * 唯一需要判断的就是如果map内已经存在的当前i指向的字符，将left更新一下即可
 * 而left的作用也仅仅是为了计算max
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String test = "abcabcbb";
        System.out.println(new Solution().lengthOfLongestSubstring(test));
    }
}

