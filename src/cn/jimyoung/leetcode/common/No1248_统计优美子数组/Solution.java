package cn.jimyoung.leetcode.common.No1248_统计优美子数组;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * <p>
 * 请返回这个数组中「优美子数组」的数目。
 */
public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0, count = 0, res = 0;
        while (right < nums.length) {
            if ((nums[right++] & 1) == 1) {
                count++;
            }

            if (count == k) {
                int temp = right;
                while (right < nums.length && (nums[right] & 1) == 0) {
                    right++;
                }
                int r = right-temp+1;
                int l = left;
                while((nums[left] & 1) == 0){
                    left++;
                }
                l = left-l+1;
                res+= l * r;

                left++;
                count--;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(new Solution().numberOfSubarrays(test, 2));
    }
}
