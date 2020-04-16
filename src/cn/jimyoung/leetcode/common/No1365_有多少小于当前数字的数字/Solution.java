package cn.jimyoung.leetcode.common.No1365_有多少小于当前数字的数字;

import java.util.Arrays;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] res = new int[nums.length];
        for (int num : nums) count[num]++;
        for (int i = 1; i < count.length; i++) count[i] += count[i - 1];
        for (int i = 0; i < res.length; i++)
            if(nums[i]!=0)
                res[i] = count[nums[i]-1];
        return res;
    }

    public static void main(String[] args) {
        int[] test = {8,1,2,2,3};
        System.out.println(Arrays.toString(new Solution().smallerNumbersThanCurrent(test)));
    }
}
