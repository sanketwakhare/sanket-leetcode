class Solution {
    public int minCost(String colors, int[] neededTime) {
        int minCost = 0;
        int left = 0;
        int right = 0;
        int n = colors.length();
        char[] colorsArr = colors.toCharArray();
        int currMax = 0;
        int currTotal = 0;
        while(right < n) {
            if(colorsArr[left] != colorsArr[right]) {
                // update total time
                minCost += currTotal - currMax;
                // reset
                left = right;
                currMax = neededTime[left];
                currTotal = neededTime[left];                
            } else if(colorsArr[left] == colorsArr[right]) {
                currMax = Math.max(currMax, neededTime[right]);
                currTotal += neededTime[right];                
            }
            right++;
        }
        // update total time
        minCost += currTotal - currMax;
        return minCost;        
    }
}