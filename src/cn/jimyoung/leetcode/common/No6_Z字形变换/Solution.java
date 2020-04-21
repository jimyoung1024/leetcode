package cn.jimyoung.leetcode.common.No6_Z字形变换;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        int count = 0, x = 1, rowIndex = 0;
        List<StringBuilder> list = new ArrayList<>(numRows);
        for (int i = 0; i < len; i++) {
            list.add(new StringBuilder());
        }
        while (count<len){
            list.get(rowIndex).append(s.charAt(count));
            rowIndex+=x;
            if(rowIndex == numRows-1 || rowIndex == 0) x = -x;
            count++;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder temp : list) {
            res.append(temp);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String test = "LEETCODEISHIRING";
        System.out.println(new Solution().convert(test, 3));
    }
}
