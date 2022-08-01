class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
   
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] dp = new int[2][column];
        
        
        if(obstacleGrid[0][0] == 1) return 0;
        
        // row base case
        for(int j=0; j< column; j++) {
            if(obstacleGrid[0][j] == 1) break;
            dp[0][j] = 1;
        }
        
        // column base case
        for(int i=0; i < 2 && i<row; i++) {
            if(obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        
        for(int i=1; i< row; i++) {
            for(int j=0; j< column; j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i%2][j] = 0;
                } else {
                    dp[i%2][j] = dp[(i-1)%2][j];
                    if(j-1 >=0 ) {
                        dp[i%2][j] += dp[i%2][j-1];
                    }
                }
            }
        }
        return dp[(row-1) %2][column-1];
    }
}

// [[0,0,0],
//  [0,1,0],
//  [0,0,0]]
 

// dp =
// [[1,1,1],
//  [1,0,1],
//  [1,1,2]]
