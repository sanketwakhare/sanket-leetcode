class Solution {
    public int maxProfit(int[] prices) {
        // 2 transactions cap is allowed
        int k = 2;
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];

        // traversal
        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy < dp[index].length; canBuy++) {
                for (int cap = k; cap > 0; cap--) {
                    if (canBuy == 0) {
                        // if buy is possible
                        int buy = -prices[index] + dp[index + 1][1][cap];
                        int dontBuy = dp[index + 1][0][cap];
                        dp[index][0][cap] = Math.max(buy, dontBuy);
                    } else {
                        // if sell is possible
                        int sell = prices[index] + dp[index + 1][0][cap - 1];
                        int dontSell = dp[index + 1][1][cap];
                        dp[index][1][cap] = Math.max(sell, dontSell);
                    }
                }
            }
        }
        return dp[0][0][k];
    }
    
}
