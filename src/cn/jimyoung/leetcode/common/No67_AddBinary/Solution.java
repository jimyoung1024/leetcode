package cn.jimyoung.leetcode.common.No67_AddBinary;

public class Solution {
    public String addBinary(String a, String b) {
        if (a.isEmpty()) return b;
        if (b.isEmpty()) return a;
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int C = 0;//C = 进位
        char temp;
        StringBuilder result = new StringBuilder();
        while (indexA >= 0 || indexB >= 0) {
            int A = (indexA >= 0) ? a.charAt(indexA) - '0' : 0;
            int B = (indexB >= 0) ? b.charAt(indexB) - '0' : 0;
            temp = (char) ((A + B + C) % 2 + '0');
            C = (A + B + C) / 2;
            result.insert(0, temp);
            if (indexA >= 0) indexA--;
            if (indexB >= 0) indexB--;
        }
        if (C == 1) result.insert(0, '1');
        return result.toString();
    }

    public static void main(String[] args) {
        String a = "10101";
        String b = "1";
        System.out.println(new Solution().addBinary(a, b));
    }
}
