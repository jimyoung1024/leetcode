package cn.jimyoung.leetcode.common.No787_K站中转内最便宜的航班;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * DFS
 * 思路：每次都会往任意的下一站飞（需排除了A->B->A这种情况），直到到达目的地 || k<0
 * 结果：超时
 */
public class Solution {
    private final List<Integer> list = new ArrayList<>();

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        helper(flights, src, src, dst, K, 0);
        Collections.sort(list);
        return list.isEmpty() ? -1 : list.get(0);
    }

    public void helper(int[][] flights, int pre, int src, int dst, int K, int cost) {
        if (K < 0) return;
        for (int[] flight : flights) {
            //src && flight[1] != pre 是为了排除了A->B->A这种情况
            if (flight[0] == src && flight[1] != pre) {
                if (flight[1] == dst) {
                    list.add(cost + flight[2]);
                } else {
                    helper(flights, flight[0], flight[1], dst, K - 1, cost + flight[2]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = {{0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}};
        System.out.println(new Solution().findCheapestPrice(3, test, 0, 2, 1));
    }
}
