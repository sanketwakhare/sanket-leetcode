class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int ele : arr) {
            int currFreq = freqMap.getOrDefault(ele, 0);
            freqMap.put(ele, currFreq + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int key: freqMap.keySet()) {
            pq.add(freqMap.get(key));
        }
        int n = arr.length;
        int count = 0;
        int expectedSize = n / 2;
        while(expectedSize > 0) {
            expectedSize -= pq.poll();
            count++;
        }
        return count;
    }
}