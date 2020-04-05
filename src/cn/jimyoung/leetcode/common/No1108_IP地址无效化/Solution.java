package cn.jimyoung.leetcode.common.No1108_IP地址无效化;

/**
 * @author Jimyoung
 * 调用String.replace方法，没有任何技术含量
 */
public class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }

    public static void main(String[] args) {
        System.out.println(new Solution().defangIPaddr("255.100.50.0"));
    }
}
