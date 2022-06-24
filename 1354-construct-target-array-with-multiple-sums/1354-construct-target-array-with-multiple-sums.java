class Solution {
    public boolean isPossible(int[] target) {
        
        // idea: go in reverse direction and check if we can form array of 1s from input array
        
        //edge case
        if(target.length == 1) {
            return target[0] == 1;
        }
        
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        
        // add elements into heap and calculate total sum
        for(int curr: target) {
            pq.add(curr);
            sum += curr;
        }
        
        while(pq.peek() > 1) {
            // remove max from heap
            int max = pq.poll();
            // find new Element and update sum
            int sumOfRemainingElements = sum - max;
            if(sumOfRemainingElements == 1) return true;
            
            int newElement = max % sumOfRemainingElements;
            // if new element is < 1 we cannot form target array from array of 1s
            if(newElement == 0 || newElement == max) {
                return false;
            }
            sum = newElement + sumOfRemainingElements;
            // add new element back into heap
            pq.add(newElement);
        }
        
        
        return true;        
    }
}

