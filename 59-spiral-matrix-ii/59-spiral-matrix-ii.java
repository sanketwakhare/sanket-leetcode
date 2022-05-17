class Solution {
    public int[][] generateMatrix(int A) {
        int sqr = A * A;
        int counter  = 1;

        // base case
        if (A == 1) return new int[][] {{1}};

        int[][] mat = new int[A][A];
        int n = A;
        int m = A;
        int i = 0;
        int j = 0;

        while(n >=0 && m>=0) {
            for(int k=0; k<m-1; k++) {
                mat[i][j++] = counter++;
            }
            for(int k=0; k< n-1; k++) {
                mat[i++][j] = counter++;
            }
            for(int k=0; k< m-1; k++) {
                mat[i][j--] = counter++;
            }
            for(int k=0; k< n-1; k++) {
                mat[i--][j] = counter++;
            }
            i++;
            j++;
            n = n-2;
            m = m-2;
        }
        // print last element when A is odd
        if(A % 2 == 1) {
            mat[i-1][j-1] = counter;
        }
        return mat;
    }
}