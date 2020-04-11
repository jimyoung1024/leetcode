package cn.jimyoung.leetcode.common.No22_括号生成;

import com.sun.javafx.css.parser.Css2Bin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jimyoung
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            System.out.println(cur.toString());
            return;
        }

        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open+1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> test = new Solution().generateParenthesis(2);
        for (String string :test
                ) {
            System.out.println(string);
        }
    }
}
