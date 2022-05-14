class Solution {
    
    class Edge implements Comparable<Edge> {
        int u, v, w;
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
        
        public int compareTo(Edge e) {
            return this.w - e.w;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        List<List<Edge>> list = buildAdjList(n, times);

        PriorityQueue<Edge> queue = new PriorityQueue<Edge>();
        dist[k] = 0;
        queue.add(new Edge(k, k, 0));

        while (!queue.isEmpty()) {
            Edge parentEdge = queue.poll();
            int dest = parentEdge.v;
            int wt = parentEdge.w;

            if (wt == dist[dest]) {
                List<Edge> neighbors = list.get(dest);
                for (Edge edge : neighbors) {
                    if (dist[edge.v] > dist[dest] + edge.w) {
                        dist[edge.v] = dist[dest] + edge.w;
                        queue.add(new Edge(edge.u, edge.v, edge.w + parentEdge.w));
                    }
                }
            }
        }

        int maxWt = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxWt = Math.max(maxWt, dist[i]);
        }

        return maxWt;
        
    }
    
    public List<List<Edge>> buildAdjList(int n, int[][] times) {
        
        List<List<Edge>> list = new ArrayList<List<Edge>>();
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<Edge>());
        }
        
        for(int i=0; i < times.length; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            list.get(u).add(new Edge(u, v, w));
        }
        return list;
    }
}