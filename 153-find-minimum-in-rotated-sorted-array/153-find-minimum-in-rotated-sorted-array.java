class Solution {
    public int findMin(int[] nums) {
        
        // find the start position of right sorted subarray
        int pos = findStart(nums, 0, nums.length-1);
        return nums[pos];
    }
    
    private int findStart(int[] nums, int start, int end) {
        int pos = 0;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] >= nums[0]) {
                // in left part
                start = mid + 1;
            } else if(nums[mid] < nums[0]) {
                // in right part
                pos = mid;
                end = mid - 1;
            }
        }
        return pos;
    }
}