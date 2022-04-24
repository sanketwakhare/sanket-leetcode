class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<Integer>();
        
        for(int i=0; i<k; i++) {
            while(!dq.isEmpty() && nums[i] > dq.getLast()) {
                dq.removeLast();
            }
            dq.add(nums[i]);
        }
        int index = 0;
        ans[index++] = dq.getFirst();
        
        for(int i=1; i<nums.length-k+1; i++) {
            if(!dq.isEmpty() && nums[i-1] == dq.getFirst()) {
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[i-1+k] > dq.getLast()) {
                dq.removeLast();
            }
            dq.add(nums[i-1+k]);
            ans[index++] = dq.getFirst();
        }
        return ans;
        
        
    }
}