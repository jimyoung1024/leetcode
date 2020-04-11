package cn.jimyoung.leetcode.common.No17_电话号码的字母组合;

import java.util.LinkedList;
import java.util.List;

/**
 * 经典DFS解题思路
 * @author Jimyoung
 */
public class Solution {
    private static String[] button = {"","abc","def",
                                    "ghi","jkl","mno",
                                    "pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if(digits.isEmpty()){
            return list;
        }
        helper(digits, 0, new StringBuilder(), list);
        return list;
    }
    void helper(String digits, int index, StringBuilder res, List<String> list){
        //dfs最后一层的下一层
        if(index == digits.length()){
            list.add(res.toString());
        }else {
            String string = button[(digits.charAt(index)) - '0' -1];
            for (int i = 0; i < string.length(); i++) {
                res.append(string.charAt(i));
                helper(digits, index+1, res, list);
                res.deleteCharAt(res.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
