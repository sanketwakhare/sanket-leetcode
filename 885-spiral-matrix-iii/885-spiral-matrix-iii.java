class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int cells = rows * cols;
        int mat[][] = new int[cells][2];

        int i = rStart + 1;
        int j = cStart;
        int n = 2;
        int m = 2;

        int cellCount = 0;
        while (cellCount < cells) {

            for (int k = 0; k < n - 1; k++) {
                i--;
                if (isSafe(i, j, rows, cols)) {
                    mat[cellCount % cells] = new int[] { i, j };
                    cellCount++;
                }
            }
            for (int k = 0; k < m - 1; k++) {
                j++;
                if (isSafe(i, j, rows, cols)) {
                    mat[cellCount % cells] = new int[] { i, j };
                    cellCount++;
                }
            }
            for (int k = 0; k < n - 1; k++) {
                i++;
                if (isSafe(i, j, rows, cols)) {
                    mat[cellCount % cells] = new int[] { i, j };
                    cellCount++;
                }
            }
            for (int k = 0; k < m - 1; k++) {
                j--;
                if (isSafe(i, j, rows, cols)) {
                    mat[cellCount % cells] = new int[] { i, j };
                    cellCount++;
                }
            }

            m = m + 2;
            n = n + 2;
            i++;
            j--;
        }

        return mat;
    }

    public boolean isSafe(int i, int j, int rows, int cols) {
        boolean isSafe = false;
        isSafe = (i >= 0 && i < rows && j >= 0 && j < cols);
        return isSafe;
    }
}