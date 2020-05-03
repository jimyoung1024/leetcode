package cn.jimyoung.leetcode.competition.No5400_旅行终点站;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi]
 * 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，
 * 即没有任何可以通往其他城市的线路的城市。
 * <p>
 * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
 * https://leetcode-cn.com/contest/weekly-contest-187/problems/destination-city/
 *
 * @author lijinyang
 */
public class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(1));
        }
        for (List<String> path : paths) {
            set.remove(path.get(0));
        }
        if (set.size() == 1) {
            for (String s : set) {
                return s;
            }
        }
        return null;
    }
}
