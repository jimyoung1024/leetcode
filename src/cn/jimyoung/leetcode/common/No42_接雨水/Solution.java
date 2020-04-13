package cn.jimyoung.leetcode.common.No42_接雨水;

/**
 * @author Jimyoung
 * 方法一：按列求
 */
public class Solution {
    public int trap(int[] height) {
        int sum = 0;
        //不考虑最左和最右，因为这两个地点不可能存水
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = height[i];
            int maxRight = height[i];
            for (int left = i - 1; left >= 0; left--) {
                maxLeft = Math.max(maxLeft, height[left]);
            }
            for (int right = i + 1; right < height.length; right++) {
                maxRight = Math.max(maxRight, height[right]);
            }
            int min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution().trap(test));
    }
}
