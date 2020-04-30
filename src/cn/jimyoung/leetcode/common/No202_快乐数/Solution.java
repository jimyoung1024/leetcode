package cn.jimyoung.leetcode.common.No202_快乐数;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private final Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if(n<=0) return false;
        if(set.contains(n)) {
            return false;
        }
        int res = 0;
        int temp = n;
        while (temp>0){
            res += (temp%10)*(temp%10);
            temp /=10;
        }
        set.add(n);
        return res == 1 || isHappy(res);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(2));

    }
}
