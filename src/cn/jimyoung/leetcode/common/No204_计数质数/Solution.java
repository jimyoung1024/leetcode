package cn.jimyoung.leetcode.common.No204_计数质数;

public class Solution {
    public int countPrimes(int n) {
        if (n<=3) return 0;
        int count = 0;
        for (int i = 2; i <= n; i++) {
            count++;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if((i%j) == 0){
                    count--;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countPrimes(3));
    }
}
