package cn.jimyoung.leetcode.common.No338_比特位计数;

public class Solution {
    public int[] countBits(int num) {
        if (num == 0) return new int[0];
        int[] res = new int[num + 1];
        for (int i = 0; i < res.length; i++) {
            if (i < 2) {
                res[i] = i;//将i=0和i=1两种情况合在一起,制作DP初始数据
            } else {
                if (i % 2 == 0) res[i] = res[i / 2];
                else res[i] = res[i - 1] + 1;
            }
        }
        return res;
    }
}
