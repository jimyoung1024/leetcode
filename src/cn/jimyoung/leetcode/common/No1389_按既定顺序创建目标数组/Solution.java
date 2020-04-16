package cn.jimyoung.leetcode.common.No1389_按既定顺序创建目标数组;


import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i],nums[i]);
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
