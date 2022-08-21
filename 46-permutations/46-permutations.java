class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, result);
        return result;
    }
    
    public void backtrack(int i, int[] nums, List<List<Integer>> result) {
        if(i == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int ele : nums) {
                list.add(ele);
            }
            result.add(list);
        }
        
        for(int index = i; index < nums.length; index++) {
            swap(nums, index, i);
            backtrack(i + 1, nums, result);
            swap(nums, index, i);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}