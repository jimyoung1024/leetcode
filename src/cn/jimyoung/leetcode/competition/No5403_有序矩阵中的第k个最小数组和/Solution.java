package cn.jimyoung.leetcode.competition.No5403_有序矩阵中的第k个最小数组和;

import java.util.Arrays;

/**
 * 给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。
 * <p>
 * 你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。
 * https://leetcode-cn.com/contest/weekly-contest-187/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/
 *
 * @author lijinyang
 */
public class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int xLen = mat[0].length;
        int yLen = mat.length;
        int[] resArr = new int[yLen];
        for (int i = 0; i < yLen; i++) {
            resArr[i] = mat[i][0];
        }
        for (int i = 1; i < k; i++) {

        }
        int res = 0;
        for (int i : resArr) {
            res += i;
        }
        return res;
    }
}
