package cn.jimyoung.leetcode.common.No289_生命游戏;

/**
 * @author Jimyoung
 * 题目
 * 1. 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 2. 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 3. 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 4. 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
 * 一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 */
public class Solution {
    /**
     * 增加两个状态，避免使用额外的数组
     */
    final static int SURVIVOR_TO_DEATH = 2;
    final static int DEATH_TO_SURVIVOR = 3;

    public void gameOfLife(int[][] board) {
        if (board == null) {
            return;
        }
        int height = board.length;
        int width = board[0].length;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int count = 0;
                if (x + 1 < width) {
                    if (board[y][x + 1] == 1 || board[y][x + 1] == SURVIVOR_TO_DEATH) {
                        count++;
                    }
                }
                if (y + 1 < height) {
                    if (board[y + 1][x] == 1 || board[y + 1][x] == SURVIVOR_TO_DEATH) {
                        count++;
                    }
                }
                if (x - 1 >= 0) {
                    if (board[y][x - 1] == 1 || board[y][x - 1] == SURVIVOR_TO_DEATH) {
                        count++;
                    }
                }
                if (y - 1 >= 0) {
                    if (board[y - 1][x] == 1 || board[y - 1][x] == SURVIVOR_TO_DEATH) {
                        count++;
                    }
                }
                if (x - 1 >= 0 && y - 1 >= 0) {
                    if (board[y - 1][x - 1] == 1 || board[y - 1][x - 1] == SURVIVOR_TO_DEATH) {
                        count++;
                    }
                }
                if (x - 1 >= 0 && y + 1 < height) {
                    if (board[y + 1][x - 1] == 1 || board[y + 1][x - 1] == SURVIVOR_TO_DEATH) {
                        count++;
                    }
                }
                if (x + 1 <width && y - 1 >= 0) {
                    if (board[y - 1][x + 1] == 1 || board[y - 1][x + 1] == SURVIVOR_TO_DEATH) {
                        count++;
                    }
                }
                if (x + 1 < width && y + 1 < height) {
                    if (board[y + 1][x + 1] == 1 || board[y + 1][x + 1] == SURVIVOR_TO_DEATH) {
                        count++;
                    }
                }
                if (board[y][x] == 1) {
                    if (count < 2 || count > 3) {
                        board[y][x] = SURVIVOR_TO_DEATH;
                    }
                } else {
                    if (count == 3) {
                        board[y][x] = DEATH_TO_SURVIVOR;
                    }
                }
            }
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (board[y][x] == SURVIVOR_TO_DEATH) {
                    board[y][x] = 0;
                }
                if (board[y][x] == DEATH_TO_SURVIVOR) {
                    board[y][x] = 1;
                }
            }
        }
    }
}
