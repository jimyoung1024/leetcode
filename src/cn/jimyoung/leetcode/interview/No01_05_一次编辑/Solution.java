package cn.jimyoung.leetcode.interview.No01_05_一次编辑;

/**
 * @author Jimyoung
 * 1. 两串长度相同，找出不同的字符，比较剩下字符串是否相等
 * 2. 两串长度不同，区分好长短串，如果比较到不同的字符，那么长的字符串指针往下走一步，接着比，比较剩下字符串是否相等
 */
public class Solution {
    public boolean oneEditAway(String first, String second) {
        int theLong = first.length();
        int theShort = second.length();
        if(Math.abs(theLong-theShort)>1){
            return false;
        }
        if(theShort>theLong) return oneEditAway(second,first);
        for(int i = 0; i<theShort; i++){
            if(first.charAt(i)!=second.charAt(i)){
                if(theLong == theShort){
                    return first.substring(i+1).equals(second.substring(i+1));
                }else {
                    return first.substring(i+1).equals(second.substring(i));
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().oneEditAway("teacher", "lteacher"));
        int a = 1;
        int b = 1;
        int c = a^b;

        System.out.println(c);
    }
}
