class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        int[] dp = new int[n+1];
        // base cases
        dp[0] = 1;
        dp[1] = 1;
        
        // if starting character is 0 then return 0 as we can not decode the digit
        if(s.charAt(0) == '0') return 0;
        
        for(int i=1; i<n; i++) {
            // check for single digit
            int digit = Character.getNumericValue(s.charAt(i));
            if(digit > 0 && digit <= 9) {
                // use previous value
                dp[i+1] += dp[i-1+1];
            }
            
            // check for 2 digit number, current digit and previous digit combined
            int prevDigit = Character.getNumericValue(s.charAt(i-1));
            int number = prevDigit * 10 + digit;
            if(number >= 10 && number <=26) {
                // use previous to previous value
                dp[i+1] += dp[i-2+1];
            }            
        }
        
        return dp[n];
    }
}