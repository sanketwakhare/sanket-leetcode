class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        // int[] LMax = new int[n];
        int[] RMax = new int[n];
        
        RMax[n-1] = height[n-1];
        for(int i=n-2; i>=0; i--) {
           RMax[i] = Math.max(RMax[i+1], height[i]) ;
        }
        
        int acc = 0;
        int LMax = height[0];
        for(int i=1; i< n-1; i++) {
            LMax = Math.max(LMax, height[i-1]);
            
            acc += Math.max(0, Math.min(LMax, RMax[i+1]) - height[i]);
        }
        return acc;
    }
}