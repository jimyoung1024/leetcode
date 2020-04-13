package cn.jimyoung.leetcode.common.No859_亲密字符串;

/**
 * @author Jimyoung
 * 分两种情况讨论
 * 1. A与B相等，此时只需要A(B)内有重复的字符即可
 * 2. A与B不相等，此时要找到不相等的那两对字符，设其下标分别是first和last
 * 在遍历之后简单判断A中first和last下标的字符交换后是否与B相等
 */
public class Solution {
    public boolean buddyStrings(String A, String B) {
        //先判断一些简单的情况，加快LeetCode上执行速度
        if (    A == null ||
                B == null ||
                A.length() == 0 ||
                B.length() == 0 ||
                A.length() != B.length()
        ) {
            return false;
        }
        int first = -1, last = -1;
        if (A.equals(B)) {
            //题目中说A，B串只包含小写字母
            int[] hasSame = new int[26];
            for (char c : A.toCharArray()) {
                hasSame[c - 'a']++;
            }
            for (int i : hasSame) {
                if (i > 1) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(i)) {
                    if (first == -1) {
                        first = i;
                    } else if (last == -1) {
                        last = i;
                    } else {
                        //若进入此分支，证明A,B中有超过两个的不同字符，一定不是亲密字符串
                        return false;
                    }
                }
            }
        }
        return (last != -1) &&
                (A.charAt(first) == B.charAt(last) && A.charAt(last) == B.charAt(first));
    }

    public static void main(String[] args) {
        System.out.println(new Solution().buddyStrings("ab", "ab"));
    }
}
