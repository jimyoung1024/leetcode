package cn.jimyoung.leetcode.interview.No01_02_判定是否互为字符串重排;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jimyoung
 * 看了别人的代码之后
 */
public class Solution_2 {
    public boolean CheckPermutation(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
}
