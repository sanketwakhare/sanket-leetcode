class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        
        String ans = new String();
        for(int i=0; i<length; i++) {
            String temp1 = expand(s, i,i,length);            
            if(temp1.length() > ans.length()) {
                // update answer
                ans = temp1;
            }
        }
        
        for(int i=0; i<length-1; i++) {
            String temp1 = expand(s, i,i+1,length);            
            if(temp1.length() > ans.length()) {
                // update answer
                ans = temp1;
            }
        }
        return ans;
        
    }
    
    public String expand(String s, int left, int right, int length) {
        char c1 = s.charAt(left);
        char c2 = s.charAt(right);
        while( left >=0 && right < length) {
            c1 = s.charAt(left);
            c2 = s.charAt(right);
            if(c1 == c2) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left+1, right);
    }
}