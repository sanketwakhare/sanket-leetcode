class Solution {
    public int searchInsert(int[] nums, int target) {
        int answer = 0;
        
        int start = 0;
        int end = nums.length - 1;
        while(start < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return nums[start] < target ? start + 1 : start;
    }
}