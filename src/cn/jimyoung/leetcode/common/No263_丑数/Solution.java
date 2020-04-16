package cn.jimyoung.leetcode.common.No263_丑数;

/**
 * 编写一个程序判断给定的数是否为丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 */
public class Solution {
    public boolean isUgly(int num) {
        int last;
        while (true){
            last = num;
            if(num%2 == 0) num/=2;
            if(num%3 == 0) num/=3;
            if(num%5 == 0) num/=5;
            if(num == 1) return true;
            if(num == last) return false;
        }
    }
}
