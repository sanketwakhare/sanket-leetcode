class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        // initialize required parameters for recursive function
        int[] cols = new int[n];
        int[] leftDiagonal = new int[(2 * n)];
        int[] rightDiagonal = new int[(2 * n)];
        int[][] matrix = new int[n][n];
        int index = 0;
        List<List<String>> solutions = new ArrayList<List<String>>();
        // call recursive function
        nQueens(index, cols, leftDiagonal, rightDiagonal, matrix, n, solutions);

        return solutions;
    }
    
    private void nQueens(int index, int[] cols, int[] leftDiagonal, int[] rightDiagonal, int[][] matrix, int n,
            List<List<String>> solutions) {

        if (index == n) {
            // we have successfully placed the n queens
            List<String> currentSolution = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 1) {
                        temp.append('Q');
                    } else {
                        temp.append('.');
                    }
                }
                currentSolution.add(temp.toString());
            }
            solutions.add(currentSolution);
            return;
        }

        // each row has n possibilities to place queen
        for (int j = 0; j < cols.length; j++) {

            if (cols[j] == 1 || leftDiagonal[n + index - j] == 1 || rightDiagonal[index + j] == 1) {
                // we can no further place queens in current column, check for next available
                // column
                continue;
            }

            // mark the current column, leftDiagonal and rightDiagonal as visited
            cols[j] = 1;
            leftDiagonal[n + index - j] = 1;
            rightDiagonal[index + j] = 1;
            matrix[index][j] = 1;

            nQueens(index + 1, cols, leftDiagonal, rightDiagonal, matrix, n, solutions);

            // revert the states of current column, leftDiagonal and rightDiagonal
            cols[j] = 0;
            leftDiagonal[n + index - j] = 0;
            rightDiagonal[index + j] = 0;
            matrix[index][j] = 0;
        }
    }
}