package cn.jimyoung.leetcode.common.No747_至少是其他数字两倍的最大数;

public class Solution {
    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i]) {
                return -1;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] test = {0, 0,1,2};
        System.out.println(new Solution().dominantIndex(test));
    }
}
