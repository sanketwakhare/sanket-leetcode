class MyCalendar {

    List<List<Integer>> events;
    
    public MyCalendar() {
        events = new ArrayList();
    }
    
    public boolean book(int start, int end) {
        
        // base condition
        if(events.size() == 0) {
            List<Integer> pair = new ArrayList<>();
            pair.add(start);
            pair.add(end);
            events.add(pair);
            return true;
        }
        // binary search
        
        int low = 0;
        int high = events.size()-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            List<Integer> midEvent = events.get(mid);
            
            // if it overlapping
            int midStart = midEvent.get(0);
            int midEnd = midEvent.get(1);
            if(!(end <= midStart || start >= midEnd)) {
                return false;
            }
            
            if(end <= midStart) {
                high = mid - 1;
            } else if(start >= midEnd) {
                low = mid + 1;
            }
        }
        // add event
        List<Integer> pair = new ArrayList<>();
        pair.add(start);
        pair.add(end);
        events.add(low, pair);
        return true;
        
    }
    
}


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

//         p1-----p2
//            --
//    ---------
//              ---------
//  ---------------------------
 
   
// -----
//                                 -----
            
// sorted = [[10, 20], [20,30], [35,40]]

// newinterval = [5,10]