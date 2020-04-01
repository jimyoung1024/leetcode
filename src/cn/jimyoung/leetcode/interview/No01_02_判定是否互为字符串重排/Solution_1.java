package cn.jimyoung.leetcode.interview.No01_02_判定是否互为字符串重排;

import java.util.LinkedList;
import java.util.List;

/**
 * 自己的思路
 */
public class Solution_1 {
    public boolean CheckPermutation(String s1, String s2) {
        List<Character> list = new LinkedList<>();
        for (char c:s1.toCharArray()) {
            list.add(c);
        }
        //这里使用Character是因为使用char调用的remove返回的不是boolean
        for (Character c:s2.toCharArray()) {

            if(!list.remove(c)) {
                return false;
            }
        }
        return true;
    }
}
