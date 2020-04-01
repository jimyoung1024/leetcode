package cn.jimyoung.leetcode.common.No820_单词的压缩编码;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lijinyang
 */
public class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }

        int res = 0;
        for (String string : set) {
            res += (string.length() + 1);
        }
        return res;
    }
}
