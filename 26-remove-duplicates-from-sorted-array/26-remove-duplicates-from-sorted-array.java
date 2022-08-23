class Solution {
    public int removeDuplicates(int[] nums) {
        int lastSwapped = nums[0];
        int lastSwappedIndex = 0;
        int i = 1;
        int n = nums.length;
        while(i < n) {
            if(nums[i] != lastSwapped) {
                nums[lastSwappedIndex + 1] = nums[i];                
                lastSwappedIndex += 1;
                lastSwapped = nums[i];
            }
            i++;
        }
        return lastSwappedIndex + 1;
    }
}