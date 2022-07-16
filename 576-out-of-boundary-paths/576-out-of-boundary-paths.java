class Solution {
    int[] dx = new int[] {0,0,-1,1};
    int[] dy = new int[] {-1,1,0,0};
    long p = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        
        Long[][][] dp = new Long[m+1][n+1][maxMove+1];
        return (int) dfs(m, n, maxMove, startRow, startColumn, dp);
    }
    
    public long dfs(int m, int n, int maxMove, int i, int j, Long[][][] dp) {
        
        if(maxMove < 0) return 0;
        if(i < 0 || j < 0 || i >= m || j >= n) return 1;
        if(dp[i][j][maxMove] != null ) {
            return dp[i][j][maxMove];
        }
        long count = 0;
        for(int index = 0; index < dx.length; index++) {
            int nextX = i + dx[index];
            int nextY = j + dy[index];
            count += dfs(m, n, maxMove - 1, nextX, nextY, dp);
        }
        return dp[i][j][maxMove] = count % p;
    }
}