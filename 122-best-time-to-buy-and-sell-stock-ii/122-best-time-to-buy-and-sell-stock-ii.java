class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        dp[n][0] = 0;
        dp[n][1] = 0;
        for (int index = n - 1; index >= 0; index--) {
            // buy
            int buy = (-1 * prices[index]) + dp[index + 1][0];
            // dont buy
            int dontBuy = dp[index + 1][1];
            dp[index][1] = Math.max(buy, dontBuy);
            // sell
            int sell = prices[index] + dp[index + 1][1];
            // dont sell
            int dontSell = dp[index + 1][0];
            dp[index][0] = Math.max(sell, dontSell);
        }
        return dp[0][1];
    }
}