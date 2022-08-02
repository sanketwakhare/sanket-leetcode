class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        
        for(int i=0; i < nums1.length && i < k; i++) {
            // insert first k pairs/ pairs formed with first element of nums2
            
            pq.offer(new Pair(i, 0, nums1[i] + nums2[0]));
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i< k; i++) {
            
            Pair curr = pq.poll();
            
            // do not add any pair if current pair is null
            if(curr == null) continue;
            
            // add current pair into result
            List<Integer> currPair = new ArrayList<>();
            currPair.add(nums1[curr.i]);
            currPair.add(nums2[curr.j]);
            result.add(currPair);
                     
            // add next pair
            if(curr.j + 1 < nums2.length) {
                pq.offer(new Pair(curr.i, curr.j+1, nums1[curr.i] + nums2[curr.j+1]));
            }            
        }
        return result;
    }
}

class Pair {
    int i;
    int j;
    int sum;
    
    public Pair(int i, int j, int sum) {
        this.i = i;
        this.j = j;
        this.sum = sum;
    }
}

class PairComparator implements Comparator<Pair> {
    
    @Override
    public int compare(Pair p1, Pair p2) {
        return p1.sum - p2.sum;
    }
}