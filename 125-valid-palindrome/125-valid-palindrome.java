class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int charCode = (int) ch;
            if(charCode >=65 && charCode <=90) {
                // if character is capital letter, convert into small letter
                sb.append((char)(ch + 32));
            } else if(charCode >= 97 && charCode <=122) {
                // append small letter characters as it is
                sb.append(ch);
            } else if(charCode >= 48 && charCode <= 57) {
                // append digits
                sb.append(ch);
            }
        }
        return isStringPalindrome(sb.toString());
    }
    
    public boolean isStringPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++; j--;
            } else {
                return false;
            }
        }
        return true;
    }
}