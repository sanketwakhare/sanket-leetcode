class Solution {
    
    // Apply BFS
    class Cell {
        int x;
        int y;
        int dist;
        public Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        // base case
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        Cell source = new Cell(0, 0, 1);
        Queue<Cell> queue = new LinkedList<Cell>();
        queue.add(source);
        grid[0][0] = 1;
        
        int[] dx = new int[] {-1,-1,-1,0,0,1,1,1};
        int[] dy = new int[] {-1,0,1,-1,1,-1,0,1};
        
        while(!queue.isEmpty()) {
            
            Cell curr = queue.poll();
            int currX = curr.x;
            int currY = curr.y;
            int currDistance = curr.dist;
            
            if(currX == n-1 && currY == n-1) {
                return currDistance;
            }
            
            for(int k = 0; k < dy.length; k++) {
                int newX = currX + dx[k];
                int newY = currY + dy[k];
                boolean isSafe = newX >=0 && newY >=0 && newX < n && newY < n && grid[newX][newY] == 0;
                if(isSafe) {
                    queue.add(new Cell(newX, newY, currDistance + 1));
                    grid[newX][newY] = 1;
                }
            }
        }
        
        return -1;                
    }
}