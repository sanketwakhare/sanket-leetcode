class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {-1,1,0,0};
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        // find total connected components
        for(int i=0; i< n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1') {
                    dfs(i, j, n, m, grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    // dfs recursive function
    public void dfs(int row, int col, int n, int m, char[][] grid) {
        // when cell coordinates are out of the grid. return
        if(row>=n || row<0 || col>=m || col<0) {
            return;
        }
        // when cell is already visited or it is water
        if(grid[row][col] == '0'){
            return;
        }
        // mark as visited
        grid[row][col] = '0';
        for(int i=0; i< dx.length; i++) {
            int newRow = dx[i] + row;
            int newCol = dy[i] + col;
            // apply dfs on new eligible coordinates
            if(newRow>=0 && newRow<n && newCol>=0 && newCol<m && grid[newRow][newCol] == '1') {
                dfs(newRow, newCol, n, m, grid);
            }
        }
    }
}