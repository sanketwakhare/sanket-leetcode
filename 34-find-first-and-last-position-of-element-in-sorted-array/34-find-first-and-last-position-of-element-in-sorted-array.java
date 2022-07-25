class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        answer[0] = firstOccBS(nums, target);
        answer[1] = lastOccBS(nums, target);
        return answer;
    }
    
    public int firstOccBS(int[] nums, int target) {
        int answer = -1;
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid= start + (end - start) / 2;
            if(nums[mid] == target) {
                answer = mid;
                end = mid - 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
    
    public int lastOccBS(int[] nums, int target) {
        int answer = -1;
        int start = 0;
        int end = nums.length-1;
        while(start <= end) {
            int mid= start + (end - start) / 2;
            if(nums[mid] == target) {
                answer = mid;
                start = mid + 1;
            } else if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return answer;
    }
}