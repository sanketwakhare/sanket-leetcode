class Solution {
    
    /**
    * Approach : 1d dp array of size m
    SC: O(m)
    **/
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[] = new int[m];
        
        // fill first row
        for(int j=0;j<m; j++) {
            if(obstacleGrid[0][j] == 1) {
                // obstacle
                dp[j] = 0;
            } else {
                if(j ==0) {
                    dp[j] = 1;
                } else {
                    dp[j] = dp[j-1];
                }
            }
        }
        
        // fill remaining elements
        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(obstacleGrid[i][j] == 1) {
                    // obstacle
                    dp[j] = 0;
                } else if(j==0) {
                    dp[j] = dp[j];
                } else {
                    dp[j] = dp[j] + dp[j-1];
                }
            }
        }
        
        return dp[m-1];        
    }
    
    
    /**
    * Approach: with 2d dp array
    SC: O(n x m)
    **/
    public int uniquePathsWithObstacles_2ddparray(int[][] obstacleGrid) {
        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        
        // fill first row
        for(int j=0;j<m; j++) {
            if(obstacleGrid[0][j] == 1) {
                // obstacle
                dp[0][j] = 0;
            } else {
                if(j ==0) {
                    dp[0][j] = 1;
                } else {
                    dp[0][j] = dp[0][j-1];
                }
            }
        }
        
        // fill first column
        for(int i=1; i<n; i++) {
            if(obstacleGrid[i][0] == 1) {
                // obstacle
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i-1][0];
            }
        }
        
        // fill remaining elements
        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(obstacleGrid[i][j] == 1) {
                    // obstacle
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        
        return dp[n-1][m-1];        
    }
}