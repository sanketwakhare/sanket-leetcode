class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        
        // 0 means allowed to buy
        // 1 means not allowed to buy
        for(int index = n-1; index >= 0; index--) {
            
            // buy scenarios
            int buy = -prices[index] + dp[index + 1][1];
            int dontBuy = dp[index + 1][0];
            dp[index][0] = Math.max(buy, dontBuy);
            
            // sell scenarios
            int sell = prices[index] - fee + dp[index + 1][0];
            int dontSell = dp[index + 1][1];
            dp[index][1] = Math.max(sell, dontSell);
        }
        return dp[0][0];
    }
}