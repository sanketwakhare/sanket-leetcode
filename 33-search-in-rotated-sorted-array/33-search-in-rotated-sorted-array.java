class Solution {
    public int search(int[] nums, int target) {
        // find the start position of right sorted subarray
        int pos = findStart(nums, 0, nums.length-1);
        
        int ans = -1;
        if(target >= nums[pos] && target <= nums[nums.length-1]) {
            // search in right subarray
            ans = search(nums, pos, nums.length - 1, target);
        } else {
            // search in left subarray
            ans = search(nums, 0, pos - 1, target);
        }
        
        return ans;
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
    
    private int search(int[] nums, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) /2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}