package cn.jimyoung.leetcode.competition.No5405_形成两个异或相等数组的三元组数目;

public class Solution {
    public int countTriplets(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int len = arr.length;
        int i, j, k;
        int res = 0;
        for (i = 0; i < len; i++) {
            for (k = i + 1; k < len; k++) {
                int a = arr[i];
                int b = 0;
                for (int temp = i + 1; temp <= k; temp++) b ^= arr[temp];
                for (j = i + 1; j <= k; j++) {
                    if (a == b) {
                        res++;
                    }
                    a ^= arr[j];
                    b ^= arr[j];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        System.out.println(new Solution().countTriplets(arr));
    }
}
