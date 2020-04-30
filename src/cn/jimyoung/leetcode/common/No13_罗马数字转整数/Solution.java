package cn.jimyoung.leetcode.common.No13_罗马数字转整数;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 */
public class Solution {
    public int getValue(char c){
        switch (c){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:
                System.out.println("error");
                return 0;
        }
    }
    public int romanToInt(String s) {
        int res = 0;
        int i;
        for (i = 0; i < s.length()-1; i++) {
            char temp = s.charAt(i);
            switch (temp){
                case 'I':{
                    if(s.charAt(i+1)=='V' || s.charAt(i+1)=='X'){
                        res-=getValue(temp);
                    }else {
                        res+=getValue(temp);
                    }
                    break;
                }
                case 'X':{
                    if(s.charAt(i+1)=='L' || s.charAt(i+1)=='C'){
                        res-=getValue(temp);
                    }else {
                        res+=getValue(temp);
                    }
                    break;
                }
                case 'C':{
                    if(s.charAt(i+1)=='D' || s.charAt(i+1)=='M'){
                        res-=getValue(temp);
                    }else {
                        res+=getValue(temp);
                    }
                    break;
                }
                default:res+=getValue(temp);
            }
        }
        res+=getValue(s.charAt(i));
        return res;
    }

    public static void main(String[] args) {
        String test = "IX";
        System.out.println(new Solution().romanToInt(test));
    }

}
