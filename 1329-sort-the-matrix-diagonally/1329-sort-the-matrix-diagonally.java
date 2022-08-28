class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        for(int d=m-1; d>=0; d--) {
            int row = 0;
            int col = d;
            List<Integer> list = new ArrayList<>();
            while(row < n && col < m) {
                list.add(mat[row][col]);
                row++;
                col++;
            }
            Collections.sort(list);
            row = 0;
            col = d;
            int index = 0;
            while(row < n && col < m && index < list.size()) {
                mat[row][col] = list.get(index++);
                row++;
                col++;
            }
        }
        for(int i=1; i< n; i++) {
            int row = i;
            int col = 0;
            List<Integer> list = new ArrayList<>();
            while(row < n && col < m) {
                list.add(mat[row][col]);
                row++;
                col++;
            }
            Collections.sort(list);
            row = i;
            col = 0;
            int index = 0;
            while(row < n && col < m && index < list.size()) {
                mat[row][col] = list.get(index++);
                row++;
                col++;
            }
        }
        return mat;
    }
}