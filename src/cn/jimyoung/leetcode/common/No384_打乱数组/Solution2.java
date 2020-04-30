package cn.jimyoung.leetcode.common.No384_打乱数组;

import java.util.Random;

public class Solution2 {
    private final int[] origin;
    private final int[] shuffleNums;
    private final Random random = new Random();

    public Solution2(int[] nums) {
        origin = nums;
        shuffleNums = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return origin;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        if (shuffleNums.length == 0) return shuffleNums;
        int index1 = random.nextInt(shuffleNums.length);
        int index2 = random.nextInt(shuffleNums.length);
        int temp = shuffleNums[index1];
        shuffleNums[index1] = shuffleNums[index2];
        shuffleNums[index2] = temp;
        return shuffleNums;
    }
}