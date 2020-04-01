package cn.jimyoung.leetcode.interview.No01_01_判断字符是否唯一;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        for (char c : astr.toCharArray()
        ) {
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }
}
