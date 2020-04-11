package cn.jimyoung.leetcode.common.No39_组合总和;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jimyoung
 * Solution2是一种更为高效的方案，LeetCode上速度差50倍以上
 */
public class Solution {
    private List<List<Integer>> lists = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new LinkedList<>());
        return lists;
    }
    void dfs(int[] candidates, int subTarget, List<Integer> list){
        if(subTarget == 0){
            List<Integer> copyList = new LinkedList<>(list);
            Collections.sort(copyList);
            if(!lists.contains(copyList)) {
                lists.add(copyList);
            }
        }else {
            for (Integer i : candidates) {
                if(i<=subTarget){
                    list.add(i);
                    dfs(candidates, subTarget-i, list);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,7};
        int target = 7;
        System.out.println(new Solution().combinationSum(candidates, target));
    }
}
