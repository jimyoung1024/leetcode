package cn.jimyoung.leetcode.interview.No01_03_URL化;

/**
 * @author Jimyoung
 * 直接调用库了
 * 这个方法速度没有Solution快
 */
public class Solution_2 {
    public String replaceSpaces(String S, int length) {
        return S.substring(0,length).replaceAll(" ", "%20");
    }
}
