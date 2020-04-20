package cn.jimyoung.leetcode.common.No200_岛屿数量;

public class Solution {
    boolean[][] isVisited;

    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int res = 0;
        isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!isVisited[i][j] && grid[i][j] == '1') {
                    visit(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    void visit(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return;
        if (isVisited[x][y]) return;
        if (grid[x][y] == '0') return;
        isVisited[x][y] = true;
        visit(grid, x + 1, y);
        visit(grid, x - 1, y);
        visit(grid, x, y + 1);
        visit(grid, x, y - 1);
    }

    public static void main(String[] args) {
        char[][] test = {{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        char[][] test2 = {};
        System.out.println(new Solution().numIslands(test2));
    }
}
