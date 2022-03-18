class Solution {
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[1][m];

        /**
         * Step 1:
         * fill first row and first column with value 1 as there can be only 1 way to
         * reach those cells.
         */
        for (int i = 0; i < 1; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = 1;
        }

        /* Step 2: */
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // take same element + left element
                dp[0][j] = dp[0][j] + dp[0][j - 1];
            }
        }

        return dp[0][m - 1];
        
    }
}