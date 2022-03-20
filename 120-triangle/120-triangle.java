class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        int dp[][] = new int[n][n];
        for(int[] row: dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i<n;i++) {
            for(int j=0;j<=i;j++) {
                if(j==0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i-1][j];                    
                } else {
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j], dp[i-1][j-1]);                    
                }
            }
        }
        
        int min = dp[n-1][0];
        for(int j=0;j<n;j++) {
            min = Math.min(min, dp[n-1][j]);
        }
        return min;
        
    }
}