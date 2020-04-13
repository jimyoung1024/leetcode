package cn.jimyoung.leetcode.common.No1295_统计位数为偶数的数字;

public class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums
        ) {
            if ((helper(num) % 2) == 0) {
                count++;
            }
        }
        return count;
    }

    public int helper(int num) {
        int count = 0;
        while (num != 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().helper(89898));
    }
}
