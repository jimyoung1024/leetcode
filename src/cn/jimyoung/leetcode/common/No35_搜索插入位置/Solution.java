package cn.jimyoung.leetcode.common.No35_搜索插入位置;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] test = {1,3,5,6};
        System.out.println(new Solution().searchInsert(test, 0));
    }
}
