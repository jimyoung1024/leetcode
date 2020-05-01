package cn.jimyoung.leetcode.common.undo_No480_滑动窗口中位数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < len - k + 1; i++) {
            double temp = (double) (nums[(k / 2) + i] + nums[((k - 1) / 2) + i]) / 2.0;
            res.add(temp);
        }
        return res.stream().mapToDouble(Double::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] test = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(new Solution().medianSlidingWindow(test, 3)));
    }
}
