package cn.jimyoung.leetcode.common.No46_全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * 经典的DFS问题
 */
public class Solution {
    private final List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        fun(nums, new boolean[nums.length], 0, new ArrayList<>());
        return res;
    }
    public void fun(int[] nums, boolean[] isUsed, int subLen, List<Integer> list){
        if(subLen == nums.length){
            res.add(list);
        }
        for (int i = 0; i < nums.length; i++) {
            if(!isUsed[i]){
                isUsed[i] = true;
                List<Integer> temp = new ArrayList<>(list);
                temp.add(nums[i]);
                fun(nums, isUsed, subLen+1, temp);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {1,2,3};
        System.out.println(new Solution().permute(test));
    }
}
