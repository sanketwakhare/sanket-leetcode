class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int refill = 0, i = 0;
        int distance = startFuel;

        // refill denotes the min level by which we can reach the destination with min fuel refilling
        while (distance < target) {
            while (i < n && distance >= stations[i][0]) {
                pq.offer(stations[i]);
                i++;
            }

            if (pq.isEmpty()) return -1;

            distance += pq.remove()[1];
            refill++;
        }

        return refill;
    }
}