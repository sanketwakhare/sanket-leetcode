class Solution {
    public boolean isPossible(int[] nums) {
        
        // frequency map
        Map<Integer, Integer> freqMap = new HashMap<>();
        // hypothetical map which stores if future element can be part of existing subsequence or not
        Map<Integer, Integer> tempMap = new HashMap<>();
        
        // build frequency map
        for(int ele: nums) {
            freqMap.put(ele, freqMap.getOrDefault(ele, 0) + 1);
        }
        
        for(int ele: nums) {
            // if frequency is 0, the element is already part of existing subsequences
            if(freqMap.get(ele) == 0) continue;
            
            if(tempMap.getOrDefault(ele, 0) > 0) {
                // if current element can be appended to existing subsequences, append it
                tempMap.put(ele, tempMap.get(ele)-1);
                tempMap.put(ele+1, tempMap.getOrDefault(ele+1, 0) + 1);
                freqMap.put(ele, freqMap.get(ele) - 1);
            } else if(freqMap.getOrDefault(ele, 0) > 0 && freqMap.getOrDefault(ele + 1, 0) > 0 && freqMap.getOrDefault(ele + 2, 0) > 0) {
                // if new subsequence can be formed with at least 3 consecutive elements
                freqMap.put(ele, freqMap.get(ele) - 1);
                freqMap.put(ele+1, freqMap.get(ele+1) - 1);
                freqMap.put(ele+2, freqMap.get(ele+2) - 1);
                tempMap.put(ele+3, tempMap.getOrDefault(ele+3, 0) + 1);
            } else {
                return false;
            }
        }
        return true;
    } 
}