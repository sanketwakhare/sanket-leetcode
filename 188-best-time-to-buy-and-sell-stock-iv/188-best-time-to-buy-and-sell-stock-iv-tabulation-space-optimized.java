class Solution {
    public int maxProfit(int k, int[] prices) {
        // 2 transactions cap is allowed
        int n = prices.length;
        int[][] next = new int[2][k + 1];
        int[][] curr = new int[2][k + 1];

        // traversal
        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int cap = k; cap > 0; cap--) {
                    if (canBuy == 0) {
                        // if buy is possible
                        int buy = -prices[index] + next[1][cap];
                        int dontBuy = next[0][cap];
                        curr[0][cap] = Math.max(buy, dontBuy);
                    } else {
                        // if sell is possible
                        int sell = prices[index] + next[0][cap - 1];
                        int dontSell = next[1][cap];
                        curr[1][cap] = Math.max(sell, dontSell);
                    }
                }
            }
            // assign updated result to next as we are moving in reverse direction
            next = curr;
        }
        return curr[0][k];
    }
    
}
