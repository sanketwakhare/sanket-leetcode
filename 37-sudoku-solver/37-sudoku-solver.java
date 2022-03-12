class Solution {
    
    char[][] answer;
    
    public void solveSudoku(char[][] board) {
        
        answer = new char[9][9];
        sudokuRecursive(0, board);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                board[i][j] = answer[i][j];
            }
        }
    }
    
    private void sudokuRecursive(int index, char[][] mat) {

        // base condition when we completely solve the sudoku
        if (index == 81) {
            // create clone of the solved sudoku
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    answer[i][j] = mat[i][j];
                }
            }
            return;
        }

        // calculate row and column index
        int r = index / 9;
        int c = index % 9;

        // if already placed
        if (mat[r][c] != '.') {
            sudokuRecursive(index + 1, mat);
            return;
        }

        // each position has 9 possibilities
        for (char k = '1'; k <= '9'; k++) {
            if (checkIfkCanBePlaced(r, c, k, mat)) {
                // place char k
                mat[r][c] = k;
                sudokuRecursive(index + 1, mat);
                // revert and check for next available characters
                mat[r][c] = '.';
            }
        }
        return;
    }

    private boolean checkIfkCanBePlaced(int r, int c, char k, char[][] mat) {

        // check if character k is present in current row and current column
        for (int i = 0; i < 9; i++) {
            if (mat[r][i] == k) {
                return false;
            }
            if (mat[i][c] == k) {
                return false;
            }
        }

        // check if character k is present in current cube
        int cubeRowStartIndex = r - r % 3;
        int cubeColumnStartIndex = c - c % 3;
        for (int i = cubeRowStartIndex; i < cubeRowStartIndex + 3; i++) {
            for (int j = cubeColumnStartIndex; j < cubeColumnStartIndex + 3; j++) {
                if (mat[i][j] == k) {
                    return false;
                }
            }
        }

        return true;
    }
}