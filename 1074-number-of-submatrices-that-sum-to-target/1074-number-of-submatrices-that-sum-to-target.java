class Solution {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    
      int n = matrix.length;
      int m = matrix[0].length;
      
      // generate prefix sum
      int pf[][] = new int[n+1][m+1];
      for(int i=1; i<=n; i++) {
          for(int j=1; j<=m; j++) {
              pf[i][j] = matrix[i-1][j-1] + pf[i-1][j] + pf[i][j-1] - pf[i-1][j-1];
          }
      }
      
      // // print prefix sum
      // for(int[] row: pf)
      //   System.out.println(Arrays.toString(row));
      
      int count = 0;
      Map<Integer, Integer> map = new HashMap<>();
      // fix top row and check every row as bottom row
      for(int topRow = 1; topRow <= n; topRow++) {
          for(int bottomRow = topRow; bottomRow <= n; bottomRow++) {
              // initialize map
              map.clear();
              map.put(0, 1);
              for(int col = 1; col <= m; col++) {
                  // reuse the prefix sum values of earlier rows
                  int sum = pf[bottomRow][col] - pf[topRow-1][col];
                  count += map.getOrDefault(sum - target, 0);
                  map.put(sum, map.getOrDefault(sum, 0) + 1);
              }
          }
      }
      
      return count;
  }
}