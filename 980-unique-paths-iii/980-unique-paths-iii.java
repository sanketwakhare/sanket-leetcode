class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        List<int[][]> paths = new ArrayList<int[][]>();

        int startRowIndex = 0;
        int startColIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    startRowIndex = i;
                    startColIndex = j;
                    break;
                }
            }
        }
        uniquePaths(startRowIndex, startColIndex, grid, paths, n, m);
        
        return paths.size();
        
    }
    
    public void uniquePaths(int i, int j, int[][] grid, List<int[][]> paths, int n, int m) {

        if (i < 0 || j < 0 || i == n || j == m || grid[i][j] == -1 || grid[i][j] == 3) {
            return;
        }

        if (grid[i][j] == 2) {
            // reached to destination
            if (isUniquePath(grid)) {
                int[][] temp = new int[n][m];
                for (int p = 0; p < n; p++) {
                    for (int q = 0; q < m; q++) {
                        temp[p][q] = grid[p][q];
                    }
                }
                paths.add(temp);
            }
            return;

        }

        // mark visited
        grid[i][j] = 3;

        uniquePaths(i - 1, j, grid, paths, n, m);
        uniquePaths(i + 1, j, grid, paths, n, m);
        uniquePaths(i, j - 1, grid, paths, n, m);
        uniquePaths(i, j + 1, grid, paths, n, m);

        grid[i][j] = 0;

    }

    private boolean isUniquePath(int[][] grid) {
        boolean shouldBeIncluded = true;
        for (int p = 0; p < grid.length; p++) {
            for (int q = 0; q < grid[0].length; q++) {
                if (grid[p][q] == 0) {
                    // do not include this path
                    shouldBeIncluded = false;
                    break;
                }
            }
            if (!shouldBeIncluded) {
                break;
            }
        }
        return shouldBeIncluded;
    }
}