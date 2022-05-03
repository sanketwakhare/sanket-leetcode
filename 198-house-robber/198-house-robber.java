class Solution {
    public int rob(int[] nums) {
        
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return maxSum(nums.length-1, nums, memo);
    }
    
    public int maxSum(int n, int[] nums, int[] memo) {
        
        if(n < 0) return 0;
        
        if(memo[n]!= -1) return memo[n];
        
        int x = nums[n] + maxSum(n-2, nums, memo);
        int y = maxSum(n-1, nums, memo);
        
        return memo[n] = Math.max(x, y);
    }
}