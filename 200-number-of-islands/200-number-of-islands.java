class Solution {
    
    int[] dx = new int[] {0, 0, -1, 1};
    int[] dy = new int[] {-1, 1, 0, 0};
    public int numIslands(char[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;        
        
        int count = 0;
        
        for(int i=0; i< n; i++) {
            for(int j=0; j< m; j++) {
                if(grid[i][j] == '1') {
                    bfs(i, j, grid, n, m);                    
                    count++;
                }
            }
        }
        return count;
    }
    
    public void bfs(int x, int y, char[][] grid, int n, int m) {
        
        Queue<Coordinate> queue = new LinkedList<Coordinate>();
        // add source
        queue.add(new Coordinate(x, y));
        // mark source as visited
        grid[x][y] = '0';
        
        while(!queue.isEmpty()) {
            Coordinate curr = queue.poll();
            for(int i=0; i < dx.length; i++) {
                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];                
                if(isSafe(nextX, nextY, n, m, grid)) {
                    queue.add(new Coordinate(nextX, nextY));
                    grid[nextX][nextY] = '0';
                }                
            }
        }
    }
    
    public boolean isSafe(int x, int y, int n, int m, char[][] grid) {
        if(x< 0 || y < 0 || x>=n || y >=m || grid[x][y] == '0') return false;
        return true;
    }
}

class Coordinate {
    int x;
    int y;
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
}