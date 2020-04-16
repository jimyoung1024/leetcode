package cn.jimyoung.leetcode.common.No542_01矩阵;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/**
 * BFS解法2
 * 先把0周围的1进队，这样他们的初值就是1，然后让这些1周围的1 进队，一层一层的搜
 */
public class Solution2 {
    public int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    for (int p = 0; p < 4; p++) {
                        int newX = i + dx[p];
                        int newY = j + dy[p];
                        if (newX >= 0 && newX < m && newY >= 0 && newY < n
                                && matrix[newX][newY] == 1 && res[newX][newY] == 0) {
                            res[newX][newY] = 1;
                            queue.add(new int[]{newX, newY});
                        }
                    }

                }

            }
        }
        while (!queue.isEmpty()) {
            int[] temp = queue.remove();
            int x = temp[0], y = temp[1];
            for (int p = 0; p < 4; p++) {
                int newX = x + dx[p];
                int newY = y + dy[p];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n
                        && matrix[newX][newY] == 1 && res[newX][newY] == 0) {
                    res[newX][newY] = res[x][y] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test = {{0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        System.out.println(Arrays.deepToString(new Solution2().updateMatrix(test)));
    }
}
