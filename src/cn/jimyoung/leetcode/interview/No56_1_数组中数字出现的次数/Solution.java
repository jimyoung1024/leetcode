package cn.jimyoung.leetcode.interview.No56_1_数组中数字出现的次数;

import java.util.Arrays;

public class Solution {
    public int[] singleNumbers(int[] nums) {
        int sifter = 0;
        for (int num : nums) {
            sifter ^= num;
        }
        int x = 1;
        while ((sifter & x) == 0) {
            x <<= 1;
        }
        int res1 = 0, res2 = 0;
        for (int num : nums) {
            if ((num & x) == 0) {
                res1 ^= num;
            } else {
                res2 ^= num;
            }
        }
        return new int[]{res1, res2};
    }

    public static void main(String[] args) {
        int[] test = {1,2,10,4,1,4,3,3};
        System.out.println(Arrays.toString(new Solution().singleNumbers(test)));
    }
}
