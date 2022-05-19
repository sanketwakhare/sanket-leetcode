class Solution {
     public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // initialize distance array
        int[][] dist = new int[n][m];
        int[] dx = new int[] { -1, 1, 0, 0 };
        int[] dy = new int[] { 0, 0, -1, 1 };

        // apply DFS on each source
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = dfs(matrix, i, j, n, m, dx, dy, dist);
            }
        }

        // find max value
        int maxDist = dist[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxDist = Math.max(maxDist, dist[i][j]);
            }
        }
        return maxDist;
    }

    private int dfs(int[][] matrix, int i, int j, int n, int m, int[] dx, int[] dy, int[][] dist) {

        if (dist[i][j] != 0)
            return dist[i][j];

        // initialize dist for each cell with 1 as min increasing path will be 1
        dist[i][j] = 1;
        int cellValue = matrix[i][j];
        for (int k = 0; k < dx.length; k++) {
            int neighboringRow = i + dx[k];
            int neighboringCol = j + dy[k];

            boolean isSafe = neighboringRow >= 0 && neighboringRow < n && neighboringCol >= 0
                    && neighboringCol < m;
            // if increasing path
            isSafe = isSafe && matrix[neighboringRow][neighboringCol] > cellValue;

            // apply DFS recursively
            if (isSafe) {
                dist[i][j] = Math.max(dist[i][j],
                        1 + dfs(matrix, neighboringRow, neighboringCol, n, m, dx, dy, dist));
            }
        }
        return dist[i][j];
    }

}