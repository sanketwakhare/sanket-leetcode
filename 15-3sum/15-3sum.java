class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        
        // we can sort as order does not matter here
        Arrays.sort(nums);
        
        for(int i=0; i< nums.length-2; i++) {
            // fix i
            int j = i + 1;
            int k = nums.length - 1;
            
            if(!(i==0 || nums[i - 1] != nums[i])) continue;
            
            while(j < k && k > i && j < nums.length-1 && k < nums.length) {
                
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0 && j!=k) {
                    // found triplet
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    Collections.sort(list);
                    if(!result.contains(list)) {
                        result.add(list);
                    }
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                } else if(sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }                                   
        }
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        for(List<Integer> cList: result) {
            finalList.add(cList);
        }
        return finalList;
    }
}