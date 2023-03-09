package cn.junwork.algorithm.leetcode;

public class Q121_BestTimeToBuy {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; ++i) {
            result = Math.max(result, prices[i] - min);
            min = Math.min(prices[i], min);
        }
        return result;
    }
}
