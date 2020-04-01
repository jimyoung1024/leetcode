package cn.jimyoung.leetcode.interview.No01_03_URL化;

/**
 * @author Jimyoung
 * 最先想到的方法
 */
public class Solution {
    public String replaceSpaces(String S, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<length; i++){
            if(S.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
}
