package cn.jimyoung.leetcode.competition.No5402_绝对差不超过限制的最长连续子数组;

/**
 * 给你一个整数数组 nums ，和一个表示限制的整数 limit，
 * 请你返回最长连续子数组的长度，该子数组中的"任意"两个元素之间的绝对差必须小于或者等于 limit 。
 * <p>
 * 如果不存在满足条件的子数组，则返回 0 。
 * https://leetcode-cn.com/contest/weekly-contest-187/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 *
 * @author lijinyang
 */
public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int currLen = 0;
        int maxLen = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] >= max) {
                max = nums[i];
                maxIndex = i;
            }
            if ((max - min) <= limit) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 0;
                i = Math.min(maxIndex, minIndex);
                min = nums[i + 1];
                max = nums[i + 1];
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] test = {8, 2, 4, 7};
        int[] test2 = {4, 2, 2, 2, 4, 4, 2, 2};
        int[] test3 = {10, 1, 2, 4, 7, 2};
        System.out.println(new Solution().longestSubarray(test, 4));
        System.out.println(new Solution().longestSubarray(test2, 0));
        System.out.println(new Solution().longestSubarray(test3, 5));
    }
}
