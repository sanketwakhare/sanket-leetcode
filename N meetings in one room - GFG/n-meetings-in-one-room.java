//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    
    static class Meeting {
        int start;
        int end;
        int index;
        public Meeting(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
        
        @Override
        public String toString() {
            return "["+"start:"+this.start+" end: "+this.end+" index:"+index+"]";
        }
    }
    
    static class EndTimeComparator implements Comparator<Meeting> {
        public int compare(Meeting m1, Meeting m2) {
            if(m1.end < m2.end) return -1;
            if(m1.end > m2.end) return 1;
            if(m1.index <= m2.index) return -1;
            return 1;
        }
    }
    
    public static int maxMeetings(int start[], int end[], int n)
    {
        
        List<Meeting> meetings = new ArrayList<>();
        for(int i=0; i<start.length; i++) {
            Meeting m = new Meeting(start[i], end[i], i+1);
            meetings.add(m);
        }
        
        EndTimeComparator endTimeComparator = new EndTimeComparator();
        Collections.sort(meetings, endTimeComparator);
        
        // System.out.println(meetings);
        
        List<Integer> result = new ArrayList<>();
        int currEnd = 0;
        for(Meeting m: meetings) {
            if(m.start > currEnd) {
                currEnd = m.end;
                result.add(m.index);
            }
        }
        return result.size();
    }
}
