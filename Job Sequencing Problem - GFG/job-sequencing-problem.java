//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // sort in descending order of profits
        Arrays.sort(arr, (a, b) -> {
            return b.profit - a.profit;
        });

        // find max deadline
        int maxDeadline = 0;
        for(int i=0; i<n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline);
        }

        int[] visited = new int[maxDeadline+1];
        Arrays.fill(visited, -1);

        int maxProfit = 0;
        int taskCount = 0;
        for(int i=0; i < n; i++) {
            int currDeadline = arr[i].deadline;
            int currProfit = arr[i].profit;
            
            for(int vis = currDeadline; vis > 0; vis--) {
                if(visited[vis] == -1) {
                    // perform current task at as late as possible
                    visited[vis] = i;
                    maxProfit += currProfit;
                    taskCount++;
                    break;
                }
            }
        }
        return new int[] {taskCount, maxProfit};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/