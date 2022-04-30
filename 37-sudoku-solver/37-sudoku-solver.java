class Solution {
    char[][] answer;
    public void solveSudoku(char[][] board) {
        answer = new char[9][9];
        backtrack(0, board);
        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[0].length; col++) {
                board[row][col] = answer[row][col];
            }
        } 
    }
    
    public void backtrack(int cellNumber, char[][] board) {
        
        if(cellNumber == 81) {
            // base case
            for(int row=0; row<board.length; row++) {
                for(int col=0; col<board[0].length; col++) {
                    answer[row][col] = board[row][col];
                }
            } 
            return;
        }
        
        // calculate row and col from cellIndex
        int row = cellNumber / 9;
        int col = cellNumber % 9;
        
        if(board[row][col] == '.') {
            // try all possibilities
            for(char ch='1'; ch<='9'; ch++) {
                if(isValid(ch, row, col, board)) {
                    // try putting one of the character
                    board[row][col] = ch;
                    // recursive call
                    backtrack(cellNumber + 1, board);
                    // backtrack
                    board[row][col] = '.';
                }
            }
        } else {
            // skip the cell and try for next cell
            backtrack(cellNumber + 1, board);
        }
    }
    
    public boolean isValid(char ch, int row, int col, char[][] board) {
        
        // validate row
        for(int index = 0; index < 9; index++) {
            if(board[row][index] == ch) return false;
        }
        
        // validate column
        for(int index = 0; index < 9; index++) {
            if(board[index][col] == ch) return false;
        }
        
        // validate box
        int r = row - row % 3;
        int c = col - col % 3;
        for(int i=r; i< r+3; i++) {
            for(int j=c; j< c+3; j++) {
                if(board[i][j] == ch) return false;
            }
        }
        return true;
    }
}