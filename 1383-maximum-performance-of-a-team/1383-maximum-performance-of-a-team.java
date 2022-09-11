class Pair {
    int speed;
    int efficiency;
    public Pair(int speed, int efficiency) {
        this.speed = speed;
        this.efficiency = efficiency;
    }
}

// sort yb descending order of efficiency
class EfficiencyComparator implements Comparator<Pair> {
    
    @Override
    public int compare(Pair p1, Pair p2) {
        return p2.efficiency - p1.efficiency;
    }
}

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        // sort based on efficiency in descending order
        List<Pair> pairs = new ArrayList<>();        
        for(int i=0; i<n; i++) {
            pairs.add(new Pair(speed[i], efficiency[i]));
        }
        Collections.sort(pairs, new EfficiencyComparator());
        
        // maintian min heap of size K
        PriorityQueue<Integer> pq = new PriorityQueue();
        long totalSpeed = 0;
        long max = 0;
        long m = 1000000007;
        
        for(Pair p: pairs) {
            
            int currSpeed = p.speed;
            int currEff = p.efficiency;
            if(pq.size() == k) {
                totalSpeed -= pq.poll();
            }
            pq.add(currSpeed);
            totalSpeed += currSpeed;
            long currPerf = totalSpeed * currEff;
            max = Math.max(max, currPerf);
        }
        return (int) (max % m);
    }
}