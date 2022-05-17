class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
        
        while(i < n && j >= 0) {            
            int currentEle = matrix[i][j];
            if(currentEle == target) {
                // if element is found
                return true;
            } else if(currentEle > target) {
                //serach on left
                j--;
            } else {
                //search on next rows
                i++;
            }
        }        
        return false;
    }
}