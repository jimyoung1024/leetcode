package cn.jimyoung.leetcode.interview.No13_机器人的运动范围;

public class Solution {
    private static int M;
    private static int N;
    private static int K;
    private static boolean[][] arr;

    public int movingCount(int m, int n, int k) {
        M = m;
        N = n;
        K = k;
        arr = new boolean[M][N];
        return movingCount(0, 0);
    }

    public int movingCount(int m, int n) {
        if (m >= M || n >= N) {
            return 0;
        }
        if (canReach(m, n) && !arr[m][n]) {
            arr[m][n] = true;
            return 1 + movingCount(m + 1, n) + movingCount(m, n + 1);
        } else {
            return 0;
        }
    }

    public boolean canReach(int i, int j) {
        int count = 0;
        while (i != 0) {
            count += i % 10;
            i /= 10;
        }
        while (j != 0) {
            count += j % 10;
            j /= 10;
        }
        return count <= K;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(3, 2, 17));
    }
}
