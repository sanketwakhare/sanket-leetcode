class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] t1 = new int[n-1];
        int[] t2 = new int[n-1];
        for(int i=0; i<n; i++) {
            if(i!=0) t1[i-1] = nums[i];
            if(i!=n-1) t2[i] = nums[i];
        }
        return Math.max(maxSum_4(t1), maxSum_4(t2));
    }
    
    private int maxSum_4(int[] input) {

        int n = input.length;
        if (n == 0) return 0;
        int prev2 = 0;
        int prev1 = input[0];

        for (int index = 2; index <= n; index++) {
            int pick = input[index - 1] + prev2;
            int dontPick = prev1;
            int curr = Math.max(pick, dontPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}