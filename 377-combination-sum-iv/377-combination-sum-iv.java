class Solution {
    int count = 0;
    public int combinationSum4(int[] nums, int target) {
        
        int dp[] = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        
        f(0, target, nums, dp);
        
        System.out.println(Arrays.toString(dp));
        return dp[target];
    }
    
    
    public int f(int index, int remaningSum, int[] nums, int[] dp) {
        
        // base case
        if(remaningSum == 0) {
            return 1;
        }
        
        // memoization
        if(dp[remaningSum] != -1) {
            return dp[remaningSum];
        }
        
        int count = 0;
        for(int i=0; i< nums.length; i++) {
            if(remaningSum - nums[i] >= 0 ) {
                count += f(i, remaningSum - nums[i], nums, dp);
            }
        }
        return dp[remaningSum] = count;
    }
    
}


//                 s=0, t=4
    
//     i=0, s=1, t=3    i=1, s=2, t=42   i=2, s=3, t=1
                    
//                                     i=0, s=1, t=   
                    
                    
// i=
            
    
                    
                    