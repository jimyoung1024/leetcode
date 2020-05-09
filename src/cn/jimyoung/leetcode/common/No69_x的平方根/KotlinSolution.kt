package cn.jimyoung.leetcode.common.No69_x的平方根

import kotlin.math.abs

class KotlinSolutionSolution {
    fun mySqrt(x: Int): Int {
        if (x <= 1) return x
        var x0: Double = 1.0
        var x1 = (x0 + x / x0) / 2.0;
        while (abs(x0 - x1) >= 1) {
            x0 = x1
            x1 = (x0 + x / x0) / 2.0
        }
        return x1.toInt()
    }
}