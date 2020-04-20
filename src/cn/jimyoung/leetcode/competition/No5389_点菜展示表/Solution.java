package cn.jimyoung.leetcode.competition.No5389_点菜展示表;

import javafx.beans.binding.IntegerBinding;

import java.util.*;

/**
 * 给你一个数组 orders，表示客户在餐厅中完成的订单，确切地说，
 * orders[i]=[customerName_i,tableNumber_i,foodItem_i] ，
 * 其中 customerName_i 是客户的姓名，tableNumber_i 是客户所
 * 在餐桌的桌号，而 foodItem_i 是客户点的餐品名称。
 * <p>
 * 请你返回该餐厅的 点菜展示表 。在这张表中，表中第一行为标题，
 * 其第一列为餐桌桌号 “Table” ，后面每一列都是按**字母顺序排列**的餐品名称。
 * 接下来每一行中的项则表示每张餐桌订购的相应餐品数量，
 * 第一列应当填对应的桌号，后面依次填写下单的餐品数量。
 * <p>
 * 注意：客户姓名不是点菜展示表的一部分。此外，表中的数据行应该按餐桌桌号升序排列。
 */
public class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        //TreeMap<TableNumber, 点的各种菜> HashMap<菜名，对应点菜数量>
        TreeMap<Integer, HashMap<String, Integer>> treeMap = new TreeMap<>();
        //存储所有用户点过的菜名
        List<String> foodList = new LinkedList<>();
        for (List<String> order : orders) {
            Integer tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            if (!foodList.contains(foodItem)) {
                foodList.add(foodItem);
            }
            //把当前桌号的点菜信息添加进去
            if (!treeMap.containsKey(tableNumber)) {
                treeMap.put(tableNumber, new HashMap<>());
            }
            HashMap<String, Integer> temp = treeMap.get(tableNumber);
            if (!temp.containsKey(foodItem)) {
                temp.put(foodItem, 1);
            } else {
                temp.put(foodItem, temp.get(foodItem) + 1);
            }
        }
        Collections.sort(foodList);
        foodList.add(0, "Table");
        List<List<String>> res = new LinkedList<>();
        res.add(foodList);
        List<String> temp;
        for (Map.Entry<Integer, HashMap<String, Integer>> entry : treeMap.entrySet()) {
            temp = new ArrayList<>();
            temp.add(entry.getKey().toString());
            for (int i = 1; i < foodList.size(); i++) {
                String foodName = foodList.get(i);
                if (entry.getValue().containsKey(foodName)) {
                    temp.add(entry.getValue().get(foodName).toString());
                } else {
                    temp.add("0");
                }
            }
            res.add(temp);
        }
        return res;
    }

}
