package cn.jimyoung.leetcode.common.No45_跳跃游戏II;

public class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        //表示当前步子内能跨越到的最后一个位置
        int end = 0;
        //用于存储临时的end，最后取一个最大值赋给end
        int maxPosition = 0;
        // i < nums.length-1是因为，在内层的if里，在未迈出第一步的时候steps就已经++了
        // 我们假设最极端的情况，nums[nums.length-1] == 1，这样当i == nums.length-1时
        // i==end就会判断为true， 这样steps就会++， 而实际上也确实需要最后再跳一步
        // 只要不是这种极端情况，其他情况下，是没必要跳这最后一步的，所以也就不会进入这个if
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 1, 1, 4};
        System.out.println(new Solution().jump(test));
    }
}
