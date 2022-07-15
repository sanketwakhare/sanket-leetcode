class Solution {
    
    int[] dx = new int[] {0, 0, -1, 1};
    int[] dy = new int[] {-1, 1, 0, 0};
    
    public int maxAreaOfIsland(int[][] grid) {
          
        int n = grid.length;
        int m = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i< n; i++) {
            for(int j=0; j< m; j++) {
                if(grid[i][j] == 1) {
                    int count = dfs(i, j, n, m, grid, 1);
                    if(count > maxArea) maxArea = count;
                }
            }
        }
        return maxArea;
    }
    
    public int dfs(int currX, int currY, int n, int m, int[][] grid, int count) {
        
        // mark as visited
        grid[currX][currY] = 0;
        
        for(int index = 0; index < dx.length; index++) {
            int nextX = currX + dx[index];
            int nextY = currY + dy[index];
            
            if(isSafe(nextX, nextY, n, m, grid)) {
                count = dfs(nextX, nextY, n, m, grid, count) + 1;
            }
        }
        return count;
    }
    
    public boolean isSafe(int currX, int currY,  int n, int m, int[][] grid) {
        if(currX < 0 || currY < 0 || currX >= n || currY >= m || grid[currX][currY] == 0) return false;
        return true;
    }
}

// BFS:
// // traverse entire matrix

// 0 -> ignore
// 1 -> consider

// source_cell = (0,2)
// reset count = 0
// max_count = 4

// queue = [[(1,9), 4]]
    
    
// ====================
// DFS :


// ===========
// [-1, -1, (2,1) ,(0,7)]
// [-1, -1, (2,1) ,(0,7), (0,7), (0,7)]


