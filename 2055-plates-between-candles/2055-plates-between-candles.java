class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int n = s.length();
        List<Integer> candleIndices = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '|') candleIndices.add(i);
        }
        
        int[] output = new int[queries.length];
        for(int i=0; i< queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if(l < r) {
                int startCandleIndex = findCeil(candleIndices, l);
                int endCandleIndex = findFloor(candleIndices, r);
                if(startCandleIndex == -1 || endCandleIndex == -1) {
                    output[i] = 0;    
                } else {
                    int numberOfPlates = candleIndices.get(endCandleIndex)
                        - candleIndices.get(startCandleIndex) - 1
                        - (endCandleIndex - startCandleIndex - 1);
                    output[i] = Math.max(0, numberOfPlates);
                }
            } else {
                output[i] = 0;
            }
        }
        
        return output;
    }
    
    public int findFloor(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        int answer = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int midCandleIndex = list.get(mid);
            if(midCandleIndex == target) {
                return mid;
            } else if(midCandleIndex < target) {
                answer = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }
    
    public int findCeil(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        int answer = -1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            int midCandleIndex = list.get(mid);
            if(midCandleIndex == target) {
                return mid;
            } else if(midCandleIndex < target) {
                start = mid + 1;
            } else {
                answer = mid;
                end = mid - 1;
            }
        }
        return answer;
    }
}