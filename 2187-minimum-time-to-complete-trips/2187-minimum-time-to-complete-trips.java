class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        int max = 0;
        for(int t: time) {
            max = Math.max(max, t);
        }
        long start = 1;
        long end = (long)max * totalTrips;
        
        long answer = 0;
        while(start <= end) {
            long midTime = start + (end - start) / 2;
            long currTotal = check(time, midTime);
            if(currTotal < totalTrips) {                
                start = midTime + 1;
            } else {
                answer = midTime;
                end = midTime - 1;
            }
        }
        return answer;
        
    }
    
    public long check(int[] time, long K) {
        // check how many trips can be completed in time K
        long count = 0;
        for(int i=0; i<time.length; i++) {
            count += (long)(K / time[i]);
        }
        return count;
    }
}