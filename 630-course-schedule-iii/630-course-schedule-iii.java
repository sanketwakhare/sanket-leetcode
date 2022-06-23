class Solution {
    public int scheduleCourse(int[][] courses) {
        
        // sort courses based on end date
        Arrays.sort(courses, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        int time = 0;
        for(int[] course: courses) {
            int courseDuration = course[0];
            int courseEndTime = course[1];
            if(time + courseDuration <= courseEndTime) {
                pq.add(courseDuration);
                time += courseDuration;
            } else if(!pq.isEmpty() && pq.peek() > courseDuration) {
                time -= pq.poll();
                time += courseDuration;
                pq.add(courseDuration);
            }
        }
        return pq.size();
    }
}