package cn.jimyoung.leetcode.common.No53_最大子序列和;

/**
 * @author lijinyang
 */
public class GreedySolution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        for (int i = 1; i < len; i++) {
            currSum = Math.max(nums[i], nums[i] + currSum);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
