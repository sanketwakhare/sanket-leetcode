class Solution {
    public int numTrees(int n) {
        // Generate Catalan number series from 0 to n
        // Cn = C0*Cn-1 + C1*Cn-2 +C2*Cn-3 +... + Cn-1*C0
        
        int[] dp = new int[n+1];
        dp[0] = 1;        
        
        for(int i=1 ;i <= n; i++) {            
            for(int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-1-j];
            }
        }
        return dp[n];        
    }
}