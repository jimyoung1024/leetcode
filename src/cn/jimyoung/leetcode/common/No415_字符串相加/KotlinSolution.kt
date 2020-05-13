package cn.jimyoung.leetcode.common.No415_字符串相加

class Solution {
    fun addStrings(num1: String, num2: String): String {
        val res = StringBuffer()
        var i = num1.lastIndex
        var j = num2.lastIndex
        var carry = 0//表示进位
        while (i >= 0 || j >= 0) {
            val n1 = if (i >= 0) num1[i] - '0' else 0
            val n2 = if (j >= 0) num2[j] - '0' else 0
            val temp = n1 + n2 + carry
            carry = temp / 10
            res.append(temp % 10)
            i--
            j--
        }
        if (carry == 1) res.append(1)
        return res.reverse().toString()
    }
}

fun main() {
    val string1 = "1"
    val string2 = "9"
    println(Solution().addStrings(string1, string2))

}