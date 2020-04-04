package cn.jimyoung.leetcode.common.No42_接雨水;

/**
 * @author Jimyoung
 * 思路同方法二，因为方法二中的数组每一项只用了一次，所以可以替换成双指针解法
 */
public class Solution_3 {
    public int trap(int[] height) {
        int len = height.length;
        int left = 1;
        int right = len - 2;
        int leftMax = 0;
        int rightMax = len - 1;
        int sum = 0;
        while (left <= right) {
            if (height[leftMax] < height[rightMax]) {
                if (height[leftMax] > height[left]) {
                    sum += height[leftMax] - height[left];
                } else {
                    leftMax = left;
                }
                left++;
            } else {
                if (height[rightMax] > height[right]) {
                    sum += height[rightMax] - height[right];
                } else {
                    rightMax = right;
                }
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution_3().trap(test));
    }
}
