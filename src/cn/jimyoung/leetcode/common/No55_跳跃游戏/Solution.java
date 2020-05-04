package cn.jimyoung.leetcode.common.No55_跳跃游戏;


/**
 * https://leetcode-cn.com/problems/jump-game/
 *
 * @author lijinyang
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 0) return false;
        int k = nums[0];
        int index = 0;
        while (k>0) {
            k--;
            //先做k--，这样后面的k代表的就是当前还能跳跃的步数
            if(nums.length-index<=k)
                return true;
            else
                k = Math.max(k, nums[index]);
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] test ={2,3,1,1,4};
        System.out.println(new Solution().canJump(test));
    }
}
