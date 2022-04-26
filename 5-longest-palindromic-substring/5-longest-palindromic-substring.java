class Solution {
    public String longestPalindrome(String s) {
        
        // initialize answer string
        int length = s.length();
        String ans = new String();
        
        // consider every index as left and right
        for(int i=0; i<length; i++) {
            String temp1 = expand(s, i,i,length);            
            if(temp1.length() > ans.length()) {
                // update answer
                ans = temp1;
            }
        }
        
        // consider every adjacent index as left and right
        for(int i=0; i<length-1; i++) {
            String temp1 = expand(s, i,i+1,length);            
            if(temp1.length() > ans.length()) {
                // update answer
                ans = temp1;
            }
        }
        // return max length substring
        return ans;
        
    }
    
    // expand to left and right from center and return longest palindrome string
    public String expand(String s, int left, int right, int length) {
        char c1;
        char c2;
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