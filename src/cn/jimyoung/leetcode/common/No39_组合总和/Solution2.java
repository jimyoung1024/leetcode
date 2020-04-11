package cn.jimyoung.leetcode.common.No39_组合总和;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();
    int target;
    int[] canditates;
    public List<List<Integer>> combinationSum(int[] canditates,int target){
        this.canditates = canditates;
        this.target = target;
        backtrack(new ArrayList<>(),0,target);
        return res;
    }

    private void backtrack(List<Integer> list,Integer begin,int reduse){
        if(reduse == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        //这个代码快的原因是这里不是每次都从头找，而是从当前下标开始
        //这样不仅减少了循环次数，而且避免了只是顺序不同的结果，无需去重
        for(int i = begin;i<canditates.length;i++){
            if(reduse >= canditates[i]){
                list.add(canditates[i]);
                backtrack(list,i,reduse-canditates[i]);
                list.remove(list.size()-1);
            }
        }
    }
}
