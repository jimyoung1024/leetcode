package cn.jimyoung.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
    public static boolean fun(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        int res = 0;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < arr1.length; i++) {
            res ^= arr1[i];
            res ^= arr2[i];
            sum1 += arr1[i];
            sum2 += arr2[i];
        }
        return res == 0 && sum1 == sum2;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,3,0,0,1,1};
        int[] arr2 = {2,2,0,0,2,2};
        System.out.println(fun(arr1, arr2));
    }
}