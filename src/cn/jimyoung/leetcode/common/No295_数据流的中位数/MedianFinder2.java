package cn.jimyoung.leetcode.common.No295_数据流的中位数;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 基于一个minHeap和一个maxHeap实现(可利用Java里提供的priorityQueue实现，需要自己Override比较器)
 * 思路是：用最大堆保存较小的那一半数据，用最小堆保存较大的那一半数据，让这两个堆的大小保持平衡（差不超过1）
 * 这里设计上采用让保存较小数据的最大堆比最小堆的size大1
 * 这样做的好处是，如果数据总数n为奇数，那么low.top就是中位数
 * 如果n为偶数，此时low和high的size相等，(low.top + high.top)/2.0就是中位数
 */
public class MedianFinder2 {
    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;

    public MedianFinder2() {
        low = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        high = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        // 每次先往high（最小堆）里放一个数,但操作时是先加到low里，
        // 然后在吧low.top加到high里，这样就可以保证将所有数据按大小平分两半
        low.add(num);
        high.add(low.poll());
        //但是还要保证low和high大小不能超过一，这里默认允许low比high大1
        if (low.size() < high.size()) {
            low.add(high.poll());
        }
    }

    public double findMedian() {
        return low.size() == high.size() ? (low.peek() + high.peek()) / 2.0 : low.peek();
    }

    public static void main(String[] args) {
        MedianFinder2 medianFinder = new MedianFinder2();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
