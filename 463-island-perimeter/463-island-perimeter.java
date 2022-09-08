class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        
        int perimeter = 0;
        for(int i=0; i< n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    for(int index = 0; index < dx.length; index++) {
                        int row = i + dx[index];
                        int col = j + dy[index];
                        // if the new cell is not land, add parimeter value
                        if(!(row>=0 && row <n && col>=0 && col < m && grid[row][col] == 1)) {
                            perimeter++;
                        }
                    }
                }
            }
        }
        return perimeter;
    }
}