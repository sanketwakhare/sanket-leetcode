class Solution {
    public int rob(int[] nums) {
        
        // initialize memoizaed/dp array
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        
        // function call
        return maxSum(nums.length-1, nums, memo);
    }
    
    public int maxSum(int n, int[] nums, int[] memo) {
        
        // base case
        if(n < 0) return 0;
        
        // reuse if repeated subproblems occur
        if(memo[n]!= -1) return memo[n];
        
        // consider both possibilities
        int x = nums[n] + maxSum(n-2, nums, memo);
        int y = maxSum(n-1, nums, memo);
        
        // return max sum out of 2 possibilities
        return memo[n] = Math.max(x, y);
    }
}