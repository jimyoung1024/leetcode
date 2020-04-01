package cn.jimyoung.leetcode.common.No1111_有效括号的嵌套深度;

import java.util.Arrays;

public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] answer = new int[seq.length()];
        for (int i = 0; i < seq.length(); i++) {
            answer[i] = (seq.charAt(i) == '(' ? i & 1 : (i + 1) & 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().maxDepthAfterSplit("()(())()")));
    }
}
