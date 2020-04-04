package cn.jimyoung.leetcode.common.No8_字符串转换整数;

public class Solution {
    final static int INTEGER_MAX_DIV_10 = Integer.MAX_VALUE / 10;
    final static int INTEGER_MIN_DIV_10 = Integer.MIN_VALUE / 10;

    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int len = str.length();
        int sign = 1;
        int index = 0;
        //去开头空格
        while (index < len) {
            if (str.charAt(index) != ' ') {
                break;
            }
            index++;
        }
        //判断第一个字符是否为符号
        char first = str.charAt(index);
        if (first == '-') {
            sign = -1;
            index++;
        } else if (first == '+') {
            index++;
        }
        //正式处理
        int res = 0;
        while (index < len) {
            char temp = str.charAt(index);
            if (temp < '0' || temp > '9') {
                break;
            }
            if ((res > INTEGER_MAX_DIV_10 || ((res == INTEGER_MAX_DIV_10) && ((temp - '0') > Integer.MAX_VALUE % 10)))) {
                return Integer.MAX_VALUE;
            } else if ((res < INTEGER_MIN_DIV_10 || ((res == INTEGER_MIN_DIV_10) && ((temp - '0') > -(Integer.MIN_VALUE % 10))))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (temp - '0');
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("-2147483647"));
    }
}
