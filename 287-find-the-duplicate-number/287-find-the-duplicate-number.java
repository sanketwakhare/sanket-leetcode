class Solution {
    public int findDuplicate(int[] nums) {
        
        // Approach 1 - using set
//         Set<Integer> set = new HashSet<Integer>();
        
//         for(int i=0; i< nums.length; i++) {
//             if(set.contains(nums[i])) {
//                 return nums[i];
//             } else {
//                 set.add(nums[i]);
//             }
//         }
//         return -1;
        
        // Approach 2- using cycle detection in linked list
        
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        
        // slow and fast will point to meeting point in cycle
        int head = nums[0];
        while(head != slow) {
            head = nums[head];
            slow = nums[slow];
        }
        return slow;
        
    }
}