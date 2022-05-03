class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int prev_prev = 0;
        int prev = 0;
        
        int[] dp = new int[cost.length+2];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=1; i<cost.length; i++) {
            dp[i+1] = Math.min(dp[i-1]+ cost[i-1], dp[i] + cost[i]);
        }
        return dp[dp.length-2];
    }
}
