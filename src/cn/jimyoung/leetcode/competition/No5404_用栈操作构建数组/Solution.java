package cn.jimyoung.leetcode.competition.No5404_用栈操作构建数组;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> buildArray(int[] target, int n) {
        if (target == null || target.length == 0) return new ArrayList<>();
        List<String> res = new LinkedList<>();
        int cur = 1;
        for (int i : target) {
            if (i != cur) {
                while (i != cur) {
                    res.add("Push");
                    res.add("Pop");
                    cur++;
                }
            }
            res.add("Push");
            cur++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {1, 3};
        int n = 3;
        System.out.println(new Solution().buildArray(test, n));
    }
}
