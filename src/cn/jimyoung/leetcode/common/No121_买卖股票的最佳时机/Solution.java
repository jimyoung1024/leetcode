package cn.jimyoung.leetcode.common.No121_买卖股票的最佳时机;

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if ((price - minPrice) > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] n = {2, 5, 1, 3};
        int a = new Solution().maxProfit(n);
        System.out.println(a);
    }
}
