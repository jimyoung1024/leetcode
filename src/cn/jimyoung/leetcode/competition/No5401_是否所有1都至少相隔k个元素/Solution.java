package cn.jimyoung.leetcode.competition.No5401_是否所有1都至少相隔k个元素;

/**
 * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。
 * 如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
 * https://leetcode-cn.com/contest/weekly-contest-187/problems/check-if-all-1s-are-at-least-length-k-places-away/
 *
 * @author lijinyang
 */
public class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int preIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                preIndex = i;
                break;
            }
        }
        if (preIndex == nums.length) {
            return true;
        }
        for (int i = preIndex + 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (i - preIndex < k + 1) {
                    return false;
                }
                preIndex = i;
            }
        }
        return true;
    }
}
