package cn.jimyoung.leetcode.common.No295_数据流的中位数;

import java.util.ArrayList;
import java.util.List;

/**
 * 先用插入排序实现一个，基于{@code ArrayList}
 */
public class MedianFinder {
    /**
     * initialize your data structure here.
     */
    private final List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        if (list.isEmpty()) {
            list.add(num);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > num) {
                    list.add(i, num);
                    return;
                }
            }
            list.add(num);
        }
    }

    public double findMedian() {
        int size = list.size();
        return size % 2 == 0 ? (list.get((size - 1) / 2) + list.get((size - 1) / 2 + 1)) / 2.0 : list.get((size - 1) / 2);
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
