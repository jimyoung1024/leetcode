package cn.jimyoung.leetcode.common.No91_解码方法;

/**
 * @author lijinyang
 */
public class Solution {
    int len;
    int sum = 0;

    public int numDecodings(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        len = s.length();
        helper(s, 0);
        return sum;
    }

    public void helper(String s, int index) {
        //如果已经扫描到最后一个字符就直接
        if (index == len - 1) {
            if (s.charAt(index) != '0') {
                sum++;
            }
            return;
        }

        char cur = s.charAt(index);
        char next = s.charAt(index + 1);
        switch (cur) {
            case '0':
                return;
            case '1': {
                if (next == '0') {
                    if (index + 2 < len) {
                        helper(s, index + 2);
                    } else {
                        sum++;
                    }
                } else {
                    helper(s, index + 1);
                    if (index + 2 < len) {
                        helper(s, index + 2);
                    } else {
                        sum++;
                    }
                }
                break;
            }
            case '2': {
                if (next == '0') {
                    helper(s, index + 1);
                    if (index + 2 < len) {
                        helper(s, index + 2);
                    } else {
                        sum++;
                    }
                } else if (next == '7' || next == '8' || next == '9') {
                    helper(s, index + 1);
                } else {
                    helper(s, index + 1);
                    if (index + 2 < len) {
                        helper(s, index + 2);
                    } else {
                        sum++;
                    }
                }
                break;
            }
            default: {
                helper(s, index + 1);
            }
        }
    }

    public static void main(String[] args) {
        String test = "12120";
        System.out.println(new Solution().numDecodings(test));
    }
}