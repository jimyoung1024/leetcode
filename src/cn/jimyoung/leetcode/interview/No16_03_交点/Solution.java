package cn.jimyoung.leetcode.interview.No16_03_交点;

public class Solution {
    final static double EQUAL = 0.000001;
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double k1 = (double) (start1[1]-end1[1])/(start1[0]-end1[0]);
        double k2 = (double) (start2[1]-end2[1])/(start2[0]-end2[0]);
        if(Math.abs(k1-k2) < EQUAL){
            //无聊的操作
        }
    }
}
