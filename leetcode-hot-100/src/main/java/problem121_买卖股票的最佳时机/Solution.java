package problem121_买卖股票的最佳时机;

class Solution {//DP
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        // dp[i]：第i天卖出的最大利润
        int[] dp = new int[prices.length];
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, dp[i]);
        }
        return maxProfit;
    }
}
