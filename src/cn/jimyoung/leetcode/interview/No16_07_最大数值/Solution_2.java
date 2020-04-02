package cn.jimyoung.leetcode.interview.No16_07_最大数值;

/**
 * @author Jimyoung
 * <p>
 * 此方法不能处理传入参数为long 的情况，但是便于理解
 */
public class Solution_2 {

    public int maximum(int a, int b) {
        //此处必须手动将a和b转换成long，如果不转换会发生int溢出
        long sum = (long) a + (long) b;
        long diff = (long) a - (long) b;
        /**
         * 此处的目的是取diff的绝对值
         * 讨论一下diff的正负
         * 1. diff > 0，diff>>63 为0，此时下方式子可化简为 diff = (diff ^ 0) - 0;
         * 2. diff < 0, diff>>63 为64位全1(即-1)，此时下方式子可化简为 diff = (diff ^ 111...111) - (-1)【即取反+1】
         *    与全1异或相当于对其取反，然后对其+1，相等于取该数的相反数，所以此操作等效于 diff = - diff;
         */
        diff = (diff ^ (diff >> 63)) - (diff >> 63);
        return (int) ((sum + diff) / 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution_2().maximum(Integer.MAX_VALUE, Integer.MIN_VALUE));

    }
}
