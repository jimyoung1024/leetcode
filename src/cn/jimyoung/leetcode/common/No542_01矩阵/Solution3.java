package cn.jimyoung.leetcode.common.No542_01矩阵;

import java.sql.Connection;
import java.util.Arrays;

/**
 * DP解法，从左上角和右下角往中间走
 */
public class Solution3 {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] res = new int[m][n];
        //初始化res，0的点为0； 1的点为一个很大的值（超过m+n就行）
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1)
                    res[i][j] = Integer.MAX_VALUE;
            }
        }
        //从左上角往右下走
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                }
                if (j - 1 >= 0) {
                    res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                }
            }
        }
        //从右下角往左上搜
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                }
                if (j + 1 < n) {
                    res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] test = {{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        System.out.println(Arrays.deepToString(new Solution3().updateMatrix(test)));
    }
}
