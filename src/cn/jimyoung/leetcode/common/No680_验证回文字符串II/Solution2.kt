package cn.jimyoung.leetcode.common.No680_验证回文字符串II

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 双指针解法
 * abca
 */
class Solution2 {
    fun validPalindrome(s: String): Boolean {
        if (s.isEmpty() || s.length == 1) return true
        var i = 0
        var j = s.lastIndex
        while (i < j) {
            if (s[i] == s[j]) {
                i++
                j--
            } else {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
        }
        return true
    }

    private fun isPalindrome(s: String, left: Int, right: Int): Boolean {
        var i = left
        var j = right

        while (i < j) {
            if (s[i] == s[j]) {
                i++
                j--
            } else {
                return false
            }
        }
        return true
    }
}

fun main() {
    val test = "abcac"
    println(Solution2().validPalindrome(test))
}