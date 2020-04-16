package cn.jimyoung.leetcode.common.No1281_整数的各位积和之差;


public class Solution {
    public int subtractProductAndSum(int n) {
        int a = 1;
        int b = 0;
        while (n > 0) {
            a *= n % 10;
            b += n % 10;
            n /= 10;
        }
        return a-b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subtractProductAndSum(4421));
    }
}
