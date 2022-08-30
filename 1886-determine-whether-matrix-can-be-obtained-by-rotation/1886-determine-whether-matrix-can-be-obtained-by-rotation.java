class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        if(equals(mat, target)) {
            return true;
        }
        for(int i=1; i<4; i++) {
            rotate(mat);
            if(equals(mat, target)) {
                return true;
            }
        }
        return false;
    }
    
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // transpose
        for(int i=0; i< n; i++) {
            for(int j=0; j<i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse rows
        for(int i=0; i<n; i++) {
            reverse(matrix[i]);
        }
    }
    
    public void reverse(int [] A) {
        int start = 0;
        int end = A.length - 1;
        while(start < end) {
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }
    }
    
    public boolean equals(int[][] A, int[][] B) {
        if(A.length != B.length) return false;
        if(A[0].length != B[0].length) return false;
        int n = A.length;
        int m = A[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }
}