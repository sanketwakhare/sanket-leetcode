class Solution {
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
}
