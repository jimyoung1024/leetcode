package cn.jimyoung.leetcode;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] test = {1, 4, 2, 6, 9, 7, 4, 1};
        Main m = new Main();
        m.quickSort(test);
        System.out.println(Arrays.toString(test));
    }

    public void quickSort(int[] arrs) {

        helper(arrs, 0, arrs.length - 1);
    }

    public void helper(int[] arrs, int left, int right) {
        if (left == right) return;
        int saveLeft = left, saveRight = right;
        int p = arrs[left];
        while (left < right) {
            while (arrs[right] >= p && left < right) {
                right--;
            }
            arrs[left] = arrs[right];
            while (arrs[left] <= p && left < right) {
                left++;
            }
            arrs[right] = arrs[left];
        }
        arrs[left] = p;
        helper(arrs, saveLeft, left - 1);
        helper(arrs, left + 1, saveRight);
    }
}
