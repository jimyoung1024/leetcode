package cn.jimyoung.leetcode.common.No412_FizzBuzz;

import java.util.LinkedList;
import java.util.List;

/**
 * 这个代码可优化，一般来说既不是3的倍数也不是5的倍数的情况居多，所以应该将最后一个else的判断顺序提前，以提高程序效率
 */
public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add("" + i);
            }
        }
        return res;
    }
}
