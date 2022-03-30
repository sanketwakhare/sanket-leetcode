class Solution {
    public int numDistinct(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        int[] dp = new int[m+1];
        dp[0] = 1;
        
        // n x m iterations
        for(int i=1; i<=n; i++) {
            // start right to left as d[j] depends upon previous column of previous row
            for(int j=m; j>=1; j--) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    // if characters are equal, update value
                   dp[j] = dp[j] + dp[j-1];
                }
            }
        }
        // return final value of the count of distinct subsequences
        return dp[m];
    }
}