class Solution {

    int[] backup;
    int[] temp;
    
    public Solution(int[] nums) {
        this.backup = nums.clone();
        this.temp = nums.clone();
    }
    
    public int[] reset() {
        this.temp = this.backup.clone();
        return this.backup;        
    }
    
    public int[] shuffle() {
        
        int n = temp.length;
        for(int i=n-1; i>=0; i--) {
            int index1 = (int)(Math.random() * (i+1));
            int index2 = i;        
            int t = temp[index1];
            temp[index1] = temp[index2];
            temp[index2] = t;
        }
        
        return temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */