class Solution {
    public int findPairs(int[] nums, int k) {
        
        Arrays.sort(nums);

        int count = 0;
        int i = 0, j = 1;
        
        while(i < nums.length && j < nums.length) {
            
            int diff = nums[j] - nums[i];
            if(diff < k || i == j) {
                // increase right pointer if diff is less than target or i and j are at same position
                j++;
            } else if(diff > k) {
                // increase left pointer if diff is more thatn target
                i++;
            } else {
                i++;
                count++;
                // move i to right until there are no adjacent duplicates as nums[i]
                while(i < nums.length && nums[i] == nums[i-1]) {
                    i++;
                }
            } 
            
        }
        
        return count;
        
    }
}