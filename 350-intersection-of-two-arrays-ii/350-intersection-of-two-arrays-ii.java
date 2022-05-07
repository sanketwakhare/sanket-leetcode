class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        // Idea: store nums1 in map with frequencies of given numbers
        // for each element in nums2, check if it present in map and if present decrease frequency and add element in result.
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        
        // Step 1: construct map with frequencies
        for(int i=0; i< nums1.length; i++) {
            int currEle = nums1[i];
            if(map.containsKey(currEle)) {
                map.put(currEle, map.get(currEle) + 1);
            } else {
                map.put(currEle, 1);
            }
        }
        
        // Step 2: iterate over second array and check for each element if that can be part of the intersection
        for(int i=0; i< nums2.length; i++) {
            int currEle = nums2[i];
            if(map.containsKey(currEle)) {
                result.add(currEle);
                int updatedFreq = map.get(currEle) - 1;                
                if(updatedFreq == 0) {
                    map.remove(currEle);
                } else {
                    map.put(currEle, map.get(currEle) - 1);    
                }
            }
        }
        
        // convert list to array
        int[] output = new int[result.size()];
        int k = 0;
        for(int ele: result) {
            output[k++] = ele;
        }
        return output;
    }
}