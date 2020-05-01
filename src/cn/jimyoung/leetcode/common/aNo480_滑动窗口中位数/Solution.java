package cn.jimyoung.leetcode.common.aNo480_滑动窗口中位数;

import java.util.*;

/**
 *
 */
public class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> low = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> high = new PriorityQueue<>();
        HashSet<Integer> isDelete = new HashSet<>(nums.length - k);
        //low.size - high.size
        // 这里不直接使用两个size相减判断是因为采用了延后删除的方法，只有当两个堆的top元素为被删除的元素时，才真正的移除top，否则不移除
        // 这样的话low.size就不是其是积极意义上的size，所以采用这个值来判断两个堆实际意义上的size 差值
        int lowSubHigh = 0;
        double[] res = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0) {
                int toBeDelete = nums[i - k];
                isDelete.add(toBeDelete);
                isDelete.remove(nums[i]);
                if (low.contains(toBeDelete)) lowSubHigh--;
                else if (high.contains(toBeDelete)) lowSubHigh++;

                if (isDelete.contains(low.peek())) low.poll();
                if (isDelete.contains(high.peek())) high.poll();
            }
            low.add(nums[i]);
            high.add(low.poll());
            lowSubHigh--;
            if (lowSubHigh < 0) {
                low.add(high.poll());
                lowSubHigh += 2;
            }

            if (i - k + 1 >= 0){
                System.out.println((i-k+1)+" low.peek: "+low.peek() + " high.peek: "+ high.peek());
                res[i - k + 1] = (lowSubHigh == 0) ? (low.peek() + high.peek()) / 2.0 : low.peek();
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {1,2,3,4,2,3,1,4,2};
        System.out.println(Arrays.toString(new Solution().medianSlidingWindow(test, 3)));
        /**
         * 预期结果
         * [2.0,3.0,3.0,3.0,2.0,3.0,2.0]
         */
    }
}
