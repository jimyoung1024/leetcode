package cn.jimyoung.leetcode.common.No485_最大连续1的个数;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for(int num:nums){
            if(num == 1){
                count++;
            }else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        max = Math.max(max, count);
        return max;
    }

    public static void main(String[] args) {
        int[] test = {0,0,0,0};
        System.out.println(new Solution().findMaxConsecutiveOnes(test));
    }
}
