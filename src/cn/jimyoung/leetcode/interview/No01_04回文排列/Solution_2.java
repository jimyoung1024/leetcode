package cn.jimyoung.leetcode.interview.No01_04回文排列;

/**
 * @author Jimyoung
 * 不借助jdk的set，自己实现
 * 放在LeetCode上测试，效率和第一种方法差不多
 */
public class Solution_2 {
    public boolean canPermutePalindrome(String s){
        boolean[] map = new boolean[128];
        int count = 0;
        for (char c:s.toCharArray()) {
            if (!map[c]){
                map[c] = true;
                count++;
            }else {
                map[c] = false;
                count--;
            }
        }
        return count<=1;
    }
}
