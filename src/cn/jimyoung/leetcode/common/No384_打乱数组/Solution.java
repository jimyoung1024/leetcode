package cn.jimyoung.leetcode.common.No384_打乱数组;

import java.util.Arrays;
import java.util.Random;

public class Solution {
    private final int[] origin;
    private final Random random = new Random();

    public Solution(int[] nums) {
        origin = nums;
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
        int[] newArr = origin.clone();
        int lastIndex = newArr.length - 1;
        while (lastIndex > 0) {
            int randomIndex = random.nextInt(lastIndex+1);
            int temp = newArr[lastIndex];
            newArr[lastIndex] = newArr[randomIndex];
            newArr[randomIndex] = temp;
            lastIndex--;
        }
        return newArr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{});
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
        System.out.println(Arrays.toString(solution.shuffle()));
    }
}
