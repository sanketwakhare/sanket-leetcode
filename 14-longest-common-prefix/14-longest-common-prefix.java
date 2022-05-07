class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int minLength = Integer.MAX_VALUE;
        String minString = new String();
        StringBuffer answer = new StringBuffer();
        for(String s: strs) {
            if( s.length() < minLength ) {
                minLength = s.length();
                minString = s;
            }
        }
        
        boolean isPrefixNotMatched = false;
        for(int i=0; i < minLength; i++) {
            
            for(String s: strs) {
                if(s.charAt(i) != minString.charAt(i)) {
                    isPrefixNotMatched = true;
                    break;
                }
            }
            if(isPrefixNotMatched) {
                break;
            } else {
                answer.append(minString.charAt(i));
            }
        }
        return answer.toString();
    }
}