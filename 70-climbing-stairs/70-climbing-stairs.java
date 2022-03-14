class Solution {
    public int climbStairs(int n) {
        
        // dp solution without extra space
        if(n <= 1) {
            return n;
        }
        
        int p3 = 0;
        int p2 = 1;
        int p1 = 2;
        
        for(int i=3; i<=n; i++) {
            p3 = p2;
            p2 = p1;
            p1 = p2 + p3;
        }
        return p1;

            // dp solution - with dp array
//         int[] dp = new int[n+1];
//         Arrays.fill(dp, -1);
        
//         dp[0] = 0;
//         dp[1] = 1;
//         dp[2] = 2;
        
//         for(int i=3; i<=n; i++) {
//             dp[i] = dp[i-1] + dp[i-2];
//         }
        
//         return dp[n];
        
    }
}