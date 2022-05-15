class Solution {
    public int divisorSubstrings(int num, int k) {
        
        Integer inputNo = num;
        String str = String.valueOf(inputNo);
        
        int beauty = 0;
        for(int i=0; i<=str.length()-k; i++) {
            
            String sub = str.substring(i, i+k);
            
            Integer val = Integer.valueOf(sub);
            if(val!=0 && inputNo % val == 0) {
                beauty++;
            }
        }
        return beauty;
    }
}