class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int[] dp = new int[cost.length+1];
        // base cases. we will need 0 cost to reach 1st step and for 0th step as we are already on 0th step
        dp[0] = 0;
        dp[1] = 0;
        for(int i=1; i<cost.length; i++) {
            dp[i+1] = Math.min( dp[i-1]+ cost[i-1], dp[i] + cost[i] );
        }
        return dp[dp.length-1];
    }
}
