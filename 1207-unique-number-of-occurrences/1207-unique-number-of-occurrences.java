class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        // build Map of frequencies for every element in array
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();        
        for(int i=0; i< arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int mapSize = map.size();
        
        // build hashset
        Set<Integer> set = new HashSet<Integer>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            set.add(entry.getValue());
        }
        int setSize = set.size();
        
        if(mapSize == setSize) return true;
        return false;
    }
}