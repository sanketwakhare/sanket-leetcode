class Solution {
    public int waysToSplitArray(int[] nums) {
        // prefix array
        long[] pf = new long[nums.length];
        pf[0] = (long)nums[0];
        long totalSum = nums[0];
        
        for(int i=1; i< nums.length; i++) {
            pf[i] = pf[i-1] + (long)nums[i];
            totalSum += (long)nums[i];
        }
        // System.out.println(totalSum);
        
        int validSplit = 0;
        for(int i=0; i< nums.length-1; i++) {
            
            long leftSum = pf[i];
            long rightSum = totalSum - pf[i];
            // System.out.println(leftSum);
            // System.out.println(rightSum);
            
            if(leftSum >= rightSum) {
                validSplit++;
            }
        }
        return validSplit;
    }
}