class Solution {
    public int maxResult(int[] nums, int k) {
        
        Deque<Pair<Integer, Integer>> dq = new LinkedList<>();
        dq.offerFirst(new Pair(0, nums[0]));
        int max = nums[0];
        
        for(int i=1; i < nums.length; i++) {
            
            // remove all elements from dq which
            while(!dq.isEmpty() && dq.peekFirst().getKey() < i-k) {
                dq.pollFirst();
            }
            
            max = nums[i];
            if(!dq.isEmpty()) {
                max += dq.peekFirst().getValue();
            }
            
            while(!dq.isEmpty() && dq.peekLast().getValue() <= max) {
                dq.pollLast();
            }
            dq.offerLast(new Pair(i, max));
            
        }
        
        
        return max;
        
    }
}

// class Pair {
//     int index;
//     int value;
//     new Pair()
// }

// 1 -5 4 3 -3 = 0

// if all are negative in window
// maintain index of maxNegative
// take all positives

// 10 + 4 + 0 + 3
    
// A = [-5,-1,-10,-30,-6,-7] k =2
    
// -5 -1

//     -10,-1
    
// A = [1,2,3,4,5,6] k=2
    
// -1 -2 -3
    
//     dp[i] = dp[]