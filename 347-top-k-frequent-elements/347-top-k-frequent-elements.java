class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int ele: nums) {
            freqMap.put(ele, freqMap.getOrDefault(ele, 0) + 1);
        }
        Map<Integer, List<Integer>> sortedMap = new TreeMap<>(Collections.reverseOrder());
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            List<Integer> list = sortedMap.getOrDefault(value, new ArrayList<Integer>());
            list.add(key);
            sortedMap.put(value, list);
        }
        List<Integer> result = new ArrayList<Integer>();
        for(Map.Entry<Integer, List<Integer>> entry : sortedMap.entrySet()) {
            List<Integer> list = entry.getValue();
            while(result.size() < k && list.size() > 0) {
                result.add(list.remove(0));
            }
            if(result.size() == k) break;
        }
        return result.stream().mapToInt(ele -> ele).toArray();
    }
}