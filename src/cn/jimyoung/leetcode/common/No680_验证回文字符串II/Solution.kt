package cn.jimyoung.leetcode.common.No680_验证回文字符串II

import java.util.*

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 本解法为递归解法，逻辑没有问题，但是会超时
 * 超时原因并不是出在递归上，而是因为有很多冗余的计算
 */
class Solution {
    fun validPalindrome(s: String): Boolean {
        if(s.isEmpty() || s.length == 1) return true
        return recur(s, false)
    }

    fun recur(s:String, isEdit:Boolean): Boolean{
        if(s.length == 1 || s.length == 2 && s[0] == s[s.lastIndex]){
            return true
        }else if(s[0] == s[s.lastIndex]){
            return recur(s.substring(1, s.lastIndex), isEdit)
        }else{
            if (isEdit) {
                return false
            }else{
                return recur(s.substring(1, s.length), true) || recur(s.substring(0, s.lastIndex), true)
            }
        }
    }
}
