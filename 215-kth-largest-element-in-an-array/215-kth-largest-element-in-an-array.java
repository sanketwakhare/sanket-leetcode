class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        
        int n = nums.length;
        // Collections.reverseOrder()
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i=0;i<nums.length;i++) {
            if(pq.size() == k && nums[i] <= pq.peek()) continue;
            if(pq.size() == k && nums[i] > pq.peek()) {
                pq.poll();                
            }
            pq.add(nums[i]);            
        }
        
        int answer = pq.peek();
        return answer;
    }
}