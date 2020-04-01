package cn.jimyoung.leetcode.interview.No01_04回文排列;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jimyoung
 */
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.isEmpty()){
            return true;
        }
        Set<Character> set = new HashSet<>();
        for (Character c: s.toCharArray()
             ) {
            if(set.contains(c)){
                set.remove(c);
            }else {
                set.add(c);
            }
        }
        if(set.size()<=1){
            return true;
        }else {
            return false;
        }
    }


}
