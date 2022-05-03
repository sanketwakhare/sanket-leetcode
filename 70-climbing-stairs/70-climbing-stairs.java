class Solution {
    public int climbStairs(int n) {
        
        if(n <=1) return 1;
        
        int prev = 1;
        int prev_prev = 2;
        
        
        for(int i=3; i<=n; i++) {
            int temp = prev + prev_prev;
            prev = prev_prev;
            prev_prev = temp;
        }
        return prev_prev;
    }
}