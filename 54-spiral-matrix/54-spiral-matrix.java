class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        List<Integer> result = new ArrayList<Integer>();
        if(n == 1) {
            for(int ele: matrix[0]) {
                result.add(ele);
            }
            return result;
        }
        if(m == 1) {
            for(int[] row: matrix) {
                result.add(row[0]);
            }
            return result;
        }
        
        int i = 0;
        int j = 0;        
        while(n > 1 && m > 1) {
            
            for(int k=0; k<m-1; k++) {
                result.add(matrix[i][j++]);
            }
            for(int k=0; k<n-1; k++) {
                result.add(matrix[i++][j]);
            }
            for(int k=0; k<m-1; k++) {
                result.add(matrix[i][j--]);
            }
            for(int k=0; k<n-1; k++) {
                result.add(matrix[i--][j]);
            }
            
            n = n-2;
            m = m-2;
            i++;
            j++;                        
        }
        
        // one of the n and m values will be at least be 0 or 1
        if(n == 0 || m == 0) {
            // if all elements are already traversed
            return result;
        } else if(n >= m) {
            // print remaining 1d column
            for(int k=0; k<n; k++) {
                result.add(matrix[i++][j]);
            }
        } else if(m > n) {
            // print remaining 1d row
            for(int k=0; k<m; k++) {
                result.add(matrix[i][j++]);
            }
        }
        
        return result;        
    }
}