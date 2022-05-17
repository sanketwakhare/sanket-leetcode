    class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // total no of cells
        int cells = rows * cols;
        int mat[][] = new int[cells][2];

        // start with a cell in next row
        int i = rStart + 1;
        int j = cStart;
        int n = 2;
        int m = 2;

        // spiral traversal from inner to outer boundary
        int cellCount = 0;
        while (cellCount < cells) {

            // Boundary Printing

            // print starting column in reverse direction except starting element
            for (int k = 0; k < n - 1; k++) {
                i--;
                if (isSafe(i, j, rows, cols)) {
                    mat[cellCount % cells] = new int[] { i, j };
                    cellCount++;
                }
            }
            // print first row except starting element
            for (int k = 0; k < m - 1; k++) {
                j++;
                if (isSafe(i, j, rows, cols)) {
                    mat[cellCount % cells] = new int[] { i, j };
                    cellCount++;
                }
            }
            // print last column except starting element
            for (int k = 0; k < n - 1; k++) {
                i++;
                if (isSafe(i, j, rows, cols)) {
                    mat[cellCount % cells] = new int[] { i, j };
                    cellCount++;
                }
            }
            // print last row except starting element
            for (int k = 0; k < m - 1; k++) {
                j--;
                if (isSafe(i, j, rows, cols)) {
                    mat[cellCount % cells] = new int[] { i, j };
                    cellCount++;
                }
            }

            // go to next level outside current boundary
            m = m + 2;
            n = n + 2;
            // start position for outer boundary printing
            i++;
            j--;
        }

        return mat;
    }

    // is valid cell
    public boolean isSafe(int i, int j, int rows, int cols) {
        boolean isSafe = false;
        isSafe = (i >= 0 && i < rows && j >= 0 && j < cols);
        return isSafe;
    }
}