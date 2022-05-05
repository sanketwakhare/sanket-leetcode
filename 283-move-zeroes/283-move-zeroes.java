class Solution {
    public void moveZeroes(int[] nums) {
        
        int lastZeroIndex = 0;
        for(int i=0; i< nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[lastZeroIndex];
                nums[lastZeroIndex] = temp;
                lastZeroIndex++;
            }
        }
        for(int i=lastZeroIndex; i< nums.length; i++) {
            nums[lastZeroIndex] = 0;
        }
    }
}