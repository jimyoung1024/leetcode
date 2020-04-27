package cn.jimyoung.leetcode.common.No33_搜索旋转排序数组;

/**
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            if (target == nums[left]) return left;
            if (target == nums[right]) return right;
            if (nums[left] < nums[mid]) {//左边有序，但是右边也可能有序。不过可以划在一种情况下考虑
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {//左边无序，右边就一定有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] test = {3,-1};
        Solution solution = new Solution();
        for (int i : test) {
            System.out.println(solution.search(test, i));
        }
    }
}
