package cn.jimyoung.leetcode.interview.No16_03_交点;

/**
 * @author Jimyoung
 * 太麻烦了，还没做完
 */
public class Solution {
    final static double EQUAL = 0.000001;

    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = start1[0], x2 = end1[0], x3 = start2[0], x4 = end2[0];
        int y1 = start1[1], y2 = end1[1], y3 = start2[1], y4 = end2[1];
        double k1 = (double) (y2 - y1) / (x2 - x1);
        double k2 = (double) (y4 - y3) / (x4 - x3);
        double b1 = y1-k1*x1;
        double b2 = y3-k2*x3;

        //两条线平行的情况
        if (Math.abs(k1 - k2) < EQUAL) {
            //两条线段重叠
            if(Math.abs(b1 - b2) < EQUAL){

            }
            //如果横坐标都相等，找到纵坐标最小的点
            if (x1 == x2 && x2 == x3 && x3 == x4) {
                int minY = Math.min(Math.min(y1, y2), Math.min(y3, y4));
                return new double[]{x1,minY};
            }else {
                //找到横坐标最小的点
                int minX = Math.min(Math.min(x1, x2), Math.min(x3, x4));
                if (minX == x1){
                    return new double[]{x1, y1};
                }else if (minX == x2){
                    return new double[]{x2, y2};
                }else if (minX == x3){
                    return new double[]{x3, y3};
                }else {
                    return new double[]{x4, y4};
                }
            }
        }
        return null;
    }
}
