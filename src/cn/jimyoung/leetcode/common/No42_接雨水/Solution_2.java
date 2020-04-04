package cn.jimyoung.leetcode.common.No42_接雨水;

/**
 * @author Jimyoung
 * 方法2：与按列求思路一致，只不过求左侧最高和右侧最高不再每次都遍历了，使用数组保存
 * 一次计算，永久使用
 */
public class Solution_2 {
    public int trap(int[] height) {
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        int sum = 0;
        for (int i = 1; i < len - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }
        for (int i = len - 2; i > 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum += min-height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] test = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution_2().trap(test));
    }
}
