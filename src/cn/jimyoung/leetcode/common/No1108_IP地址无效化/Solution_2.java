package cn.jimyoung.leetcode.common.No1108_IP地址无效化;

/**
 * @author Jimyoung
 * 实测这个方法比方法1快很多
 */
public class Solution_2 {
    public String defangIPaddr(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        for(char c:address.toCharArray()){
            if(c=='.'){
                stringBuilder.append("[.]");
            }else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
