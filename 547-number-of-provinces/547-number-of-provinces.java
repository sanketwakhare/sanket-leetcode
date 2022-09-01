class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        // build adjacency list from adjacency matrix
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            ArrayList<Integer> u = adjList.get(i);
            for(int j=0; j<n; j++) {
                if(isConnected[i][j] == 1 && i!=j) {
                    ArrayList<Integer> v = adjList.get(j);
                    u.add(j);
                    v.add(i);
                }
            }
        }
        
        // initialize visited array
        int[] visited = new int[n];
        Arrays.fill(visited, -1);
        int count = 0;
        
        // apply dfs on every node and count total connected components
        for(int i=0; i<n; i++) {
            if(visited[i] == -1) {
                dfs(i, adjList, visited);
                count++;
            }
        }
        return count;
    }
    
    public void dfs(int currNode, ArrayList<ArrayList<Integer>> adjList, int[] visited) {
        visited[currNode] = 1;
        for(int neighbor : adjList.get(currNode)) {
            if(visited[neighbor] == -1) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}