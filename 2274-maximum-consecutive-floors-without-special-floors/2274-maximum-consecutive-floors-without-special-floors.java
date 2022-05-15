class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        
        int[] temp = new int[special.length + 2];
        Arrays.sort(special);
        
        temp[0] = bottom;
        temp[temp.length-1] = top;
        
        for(int i=0; i< special.length; i++) {
            temp[i+1] = special[i];
        }
        
        int maxDiff = 0;
        
        for(int i=1; i< temp.length-2; i++) {
            int diff = temp[i+1] - temp[i] - 1;
            maxDiff = Math.max(diff, maxDiff);
        }
        
        maxDiff = Math.max(temp[1] - temp[0], maxDiff);
        maxDiff = Math.max(temp[temp.length-1] - temp[temp.length-2], maxDiff);
        
        return maxDiff;
    }
}