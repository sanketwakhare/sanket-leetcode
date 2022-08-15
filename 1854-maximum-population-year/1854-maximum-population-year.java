class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] years = new int[101];
        int startYear = 1950;
        int endYear = 2050;
        
        for(int i=0; i< logs.length; i++) {
            int start = logs[i][0];
            int end = logs[i][1];
            years[start - startYear] += 1;
            years[end - startYear] -= 1;
        }
        
        for(int i=1; i< years.length; i++) {
            years[i] += years[i-1];
        }
        
        
        int answer = 0;
        int maxPop = 0;
        for(int i=0; i< years.length; i++) {
            if(years[i] > maxPop) {
                maxPop = years[i];
                answer = i;
            }            
        }
        return answer + startYear;
        
    }
}