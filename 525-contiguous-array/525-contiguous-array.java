class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        
        // Step1: Convert 0s to -1s
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                nums[i] = -1;
            }
        }
        
        // Step 2: Find largest length of subarray with Sum = 0
        
        // generate prefix array
        int[] pf = new int[n];
        pf[0] = nums[0];
        for(int i=1; i< n; i++) {
            pf[i] = pf[i-1] + nums[i];
        }
        
        // Build HashMap and store first occurrence and find best answer
        int maxLength = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        // edge case for 0
        map.put(0, -1);
        for(int i=0; i<n; i++) {
            int ele = pf[i];
            if(map.containsKey(ele)) {
                // find answer
                int firstOccIndex = map.get(ele);
                if((i - firstOccIndex) > maxLength) {
                    maxLength = i - firstOccIndex;
                }
            } else {
                // add first occurrence of element
                map.put(ele, i);
            }
        }
        return maxLength;
        
    }
}