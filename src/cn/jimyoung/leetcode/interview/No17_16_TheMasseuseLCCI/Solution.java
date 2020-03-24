package cn.jimyoung.leetcode.interview.No17_16_TheMasseuseLCCI;

public class Solution {
    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int time0, time1;
        int t0 = 0, t1 = nums[0];
        for (int i = 1; i < len; i++) {
            time0 = Math.max(t0, t1);
            time1 = t0 + nums[i];

            t0 = time0;
            t1 = time1;
        }
        return Math.max(t0, t1);
    }
}
