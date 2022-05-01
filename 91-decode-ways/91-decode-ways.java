class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        if(s.charAt(0) == '0') return 0;
        
        for(int i=1; i<n; i++) {
            int digit = Character.getNumericValue(s.charAt(i));
            if(digit > 0 && digit <= 9) {
                dp[i+1] += dp[i-1+1];
            }
            int prevDigit = Character.getNumericValue(s.charAt(i-1));
            int number = prevDigit * 10 + digit;
            if(number >= 10 && number <=26) {
                dp[i+1] += dp[i-2+1];
            }
            if(number <= 9) {
                dp[i+1] += 0;
            }
        }
        
        
        return dp[n];
    }
}



// 2 2 6 5 1 0 3 0 4 5
    
//      0 1 2 3 4 5 6 7 8
// dp = 1 1 2 3 3 3 3 3 0
    
 
// 2-2-6-5-10-3
// 22-6-5-10-3
// 2-26-5-10-3


    
// dp[i] = dp[i-1] + dp[i-2] // both single and 2 digit combination

// dp[i] = dp[i-1] // only single digit 

// dp[i] = dp[i-2] // only for two digits 10 and 20

// else 
    
// 226
//     2 2 6 - 1
//     22 6 - 2 
//     2 26 - 3
    
    
//     2 2 6 5 1 3
    
//     1 2 3 3 3 6
    
    
//     2 - 2 -6 -5 -1 -3
//     22 -6 -5 -1 -3
//     2 -26 -5 -1 -3
    
//      2 -26 -5- 13
//     22 -6 -5- 13
//     2 - 2 -6 -5-13