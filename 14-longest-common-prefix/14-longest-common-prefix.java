class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int minLength = Integer.MAX_VALUE;
        String minString = new String();
        StringBuffer answer = new StringBuffer();
        
        // Step 1 - find min length string
        for(String s: strs) {
            if( s.length() < minLength ) {
                minLength = s.length();
                minString = s;
            }
        }
        
        // Step 2 - check each string with each character from min length string
        boolean isPrefixNotMatched = false;
        for(int i=0; i < minLength; i++) {
            for(String s: strs) {
                if(s.charAt(i) != minString.charAt(i)) {
                    isPrefixNotMatched = true;
                    break;
                }
            }
            if(isPrefixNotMatched) {
                // stop as prefix is not matching
                break;
            } else {
                //update prefix as it is matching with all strings
                answer.append(minString.charAt(i));
            }
        }
        return answer.toString();
    }
}