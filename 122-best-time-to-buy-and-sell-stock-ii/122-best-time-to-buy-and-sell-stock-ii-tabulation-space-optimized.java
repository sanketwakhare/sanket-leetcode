class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int nextSell = 0;
        int nextBuy = 0;
        int currSell = 0;
        int currBuy = 0;
        for (int index = n - 1; index >= 0; index--) {
            // buy
            int buy = -prices[index] + nextSell;
            // dont buy
            int dontBuy = nextBuy;
            currBuy = Math.max(buy, dontBuy);
            // sell
            int sell = prices[index] + nextBuy;
            // dont sell
            int dontSell = nextSell;
            currSell = Math.max(sell, dontSell);

            nextBuy = currBuy;
            nextSell = currSell;
        }
        return currBuy;
    }
}
