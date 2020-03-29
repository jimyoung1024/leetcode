package cn.jimyoung.leetcode.common.No88_MergeSortedArray;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];//没有必要复制成长度是m+n的
        System.arraycopy(nums1, 0, nums1Copy, 0, m);
        int i = 0, j = 0, k = 0;
        while (i < m && j < n)
            nums1[k++] = (nums1Copy[i] < nums2[j]) ? nums1Copy[i++] : nums2[j++];
        if (i < m) System.arraycopy(nums1Copy, i, nums1, i + j, m + n - i - j);
        if (j < n) System.arraycopy(nums2, j, nums1, i + j, m + n - i - j);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        new Solution().merge(a, 3, b, 3);
        System.out.println(Arrays.toString(a));
    }
}
