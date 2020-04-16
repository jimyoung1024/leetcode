package cn.jimyoung.leetcode.common.No787_K站中转内最便宜的航班;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS 没有想出来怎么存钱数
 * 没做完
 */
public class Solution2 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Integer> res = new ArrayList<>();//存放各种路线的花费
        Queue<Integer> queue = new LinkedList<>();//BFS需要
        //BFS初始化，把能到达的第一站放进去
        for (int[] flight : flights)
            if(flight[0] == src)
                queue.add(flight[1]);

        while (!queue.isEmpty()){

        }
        return -1;
    }
}
