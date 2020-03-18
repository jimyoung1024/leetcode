package cn.jimyoung.leetcode.common.No836_RectangleOverlap;

public class RectangleOverlap {
    //解法1：想一想重叠的条件
    public boolean isRectangleOverlap_1(int[] rec1, int[] rec2) {
        return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0])) &&
                (Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));
    }

    //解法2：想一想不重叠的条件
    public boolean isRectangleOverlap_2(int[] rec1, int[] rec2) {
        return rec2[2] <= rec1[0] ||//left
                rec2[1] >= rec1[3] ||//top
                rec2[0] >= rec1[2] ||//right
                rec2[3] <= rec1[1];  //bottom
    }


}