package cn.jimyoung.leetcode.common.No11_盛最多水的容器;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 第一种方法的优化方案
 * 不用每次只移动一步指针，条件允许下可以连续移动
 * 看了代码就懂了
 */
public class Solution2 {
    public int maxArea(int[] height) {
        if (height.length == 0) return 0;
        int len = height.length;
        int left = 0, right = len - 1;
        int res = 0;//最后的结果，最大盛水量
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            res = Math.max(res, (right - left) * min);
            while (left < right && height[left] <= min) left++;
            while (left < right && height[right] <= min) right--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 4, 5, 18, 17, 6};
        try {
            Constructor<?> constructor = Solution2.class.getDeclaredConstructor();
            Object instance = constructor.newInstance();
            Method method = Solution2.class.getDeclaredMethod("maxArea", int[].class);
            System.out.println(method.invoke(instance, (Object) test));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
