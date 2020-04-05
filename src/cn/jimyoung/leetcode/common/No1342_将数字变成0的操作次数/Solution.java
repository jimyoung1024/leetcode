package cn.jimyoung.leetcode.common.No1342_将数字变成0的操作次数;

public class Solution {
    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            /**
             * {@code num & 1 == 1}判断是否为奇数，只需要判断最低位（最右）是否为1
             * {@code num & -2} -2 的补码为 111.....10，在num为奇数的情况下相当于num-1
             * {@code num >> 1} 等同于num / 2
             * 但实测这么做并没有提高代码性能
             * 下面两种写法在LeetCode上性能相同
             */
            //num = (num & 1) == 1 ? num & -2 : num >> 1;
            num = (num % 2) == 1 ? num-1 : num / 2;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfSteps(14));
    }
}
