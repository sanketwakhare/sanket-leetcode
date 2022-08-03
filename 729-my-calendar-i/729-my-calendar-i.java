class MyCalendar {

    List<List<Integer>> events;
    
    public MyCalendar() {
        events = new LinkedList();
    }
    
    public boolean book(int start, int end) {
        
        // apply binary search
        int low = 0;
        int high = events.size()-1;
        
        while(low <= high) {
            
            int mid = low + (high - low) / 2;
            List<Integer> midEvent = events.get(mid);
            int midStart = midEvent.get(0);
            int midEnd = midEvent.get(1);
            
            // if new event is overlapping
            if(!(end <= midStart || start >= midEnd)) {
                return false;
            }
            
            if(end <= midStart) {
                // if event can be placed before mid event
                high = mid - 1;
            } else if(start >= midEnd) {
                // if event can be placed after mid event
                low = mid + 1;
            }
        }
        // add event at position low
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