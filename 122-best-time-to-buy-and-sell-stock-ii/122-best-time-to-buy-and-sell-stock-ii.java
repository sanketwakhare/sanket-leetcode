class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return Math.max(0, f(0, true, n, prices, dp));
    }
    
    private static int f(int index, boolean canBuy, int n, int[] values, int[][] dp) {
        if (index == n) return 0;
        int profit;
        if (canBuy) {
            if (dp[index][1] != -1) return dp[index][1];
            // buy
            int buy = -values[index] + f(index + 1, false, n, values, dp);
            // dont buy
            int dontBuy = f(index + 1, true, n, values, dp);
            profit = Math.max(buy, dontBuy);
        } else {
            if (dp[index][0] != -1) return dp[index][0];
            // sell
            int sell = values[index] + f(index + 1, true, n, values, dp);
            // dont sell
            int dontSell = f(index + 1, false, n, values, dp);
            profit = Math.max(sell, dontSell);
        }
        if (canBuy) {
            dp[index][1] = profit;
        } else {
            dp[index][0] = profit;
        }
        return profit;
    }
}