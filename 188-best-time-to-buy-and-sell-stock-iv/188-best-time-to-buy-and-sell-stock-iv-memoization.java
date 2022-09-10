class Solution {
    public int maxProfit(int k, int[] prices) {
        int cap = k;
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][cap + 1];
        for (int index = 0; index < dp.length; index++) {
            for (int buy = 0; buy < dp[index].length; buy++) {
                Arrays.fill(dp[index][buy], -1);
            }
        }

        return f(0, true, cap, n, prices, dp);
    }
    
    public int f(int index, boolean canBuy, int cap, int n, int[] prices, int[][][] dp) {
        if (index == n || cap == 0) return 0;
        int profit;
        if (canBuy) {
            if (dp[index][0][cap] != -1) return dp[index][0][cap];
            int buy = -prices[index] + f(index + 1, false, cap, n, prices, dp);
            int dontBuy = f(index + 1, true, cap, n, prices, dp);
            dp[index][0][cap] = profit = Math.max(buy, dontBuy);
        } else {
            if (dp[index][1][cap] != -1) return dp[index][1][cap];
            int sell = prices[index] + f(index + 1, true, cap - 1, n, prices, dp);
            int dontSell = f(index + 1, false, cap, n, prices, dp);
            dp[index][1][cap] = profit = Math.max(sell, dontSell);
        }
        return profit;
    }
}
