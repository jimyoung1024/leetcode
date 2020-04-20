package cn.jimyoung.leetcode.common.No11_盛最多水的容器;

/**
 * 盛水问题，经典面试题
 * 双指针解法，左指针i=0，右指针j=len-1;
 * 每次移动墙矮那端的指针，这是因为盛水量取决于矮的墙，
 * 移动高墙指针不一定改变盛水量，但是移动矮墙指针一定可以改变盛水量（盛水量=墙间距*矮墙高度）
 */
public class Solution {
    public int maxArea(int[] height) {
        if (height.length == 0) return 0;
        int len = height.length;
        int left = 0, right = len - 1;
        int res = 0;//最后的结果，最大盛水量
        while (left != right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 4, 5, 18, 17, 6};
        System.out.println(new Solution().maxArea(test));
    }
}
