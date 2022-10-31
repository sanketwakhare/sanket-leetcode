class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int row=n-1; row>=0; row--) {
            int i = row;
            int j=0;
            int value = matrix[i][j];
            while(i<n && j<m) {
                if(matrix[i][j] != value) return false;
                i++;
                j++;
            }
        }
        for(int col=1; col<m; col++) {
            int j = col;
            int i=0;
            int value = matrix[i][j];
            while(i<n && j<m) {
                if(matrix[i][j] != value) return false;
                i++;
                j++;                    
            }
        }
        return true;
    }
}