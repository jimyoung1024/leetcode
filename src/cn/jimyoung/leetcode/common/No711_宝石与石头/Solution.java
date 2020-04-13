package cn.jimyoung.leetcode.common.No711_宝石与石头;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Jimyoung
 */
public class Solution {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(int i = 0; i<J.length(); i++){
            for(int j = 0; j<S.length(); j++){
                if (J.charAt(i) == S.charAt(j)){
                    count++;
                }
            }
        }
        return count;
    }
}
