class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int row = matrix.length;
        int column = matrix[0].length;
        for(int i=0; i< row; i++) {
            for(int j=0; j< column; j++) {
                if(pq.size() < k) {
                    pq.offer(matrix[i][j]);
                } else {
                    if(pq.peek() > matrix[i][j]) {
                        pq.poll();
                        pq.offer(matrix[i][j]);
                    }
                }
            }
        }
        return pq.peek();
    }
}
