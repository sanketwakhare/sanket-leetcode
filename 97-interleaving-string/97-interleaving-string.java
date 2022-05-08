class Solution {
    
    public boolean isInterleave(String A, String B, String C) {
        int n = A.length();
        int m = B.length();
        int index = C.length();

        if (index != (n + m)) {
            return false;
        }
        int[][] dp = new int[n+1][m+1];
        for(int[] r: dp) {
            Arrays.fill(r , -1);
        }

        return check(A, B, C, n - 1, m - 1, index - 1, dp);
    }

    public boolean check(String A, String B, String C, int n, int m, int index, int[][] dp) {

        boolean state = false;
        if (n < 0 && m < 0 && index < 0) {
            return true;
        }
        
        if(dp[n+1][m+1] != -1) {
            return dp[n+1][m+1] == 1 ? true: false;
        }
        if (index >= 0 && n >= 0) {
            char ch1 = A.charAt(n);
            char ch3 = C.charAt(index);
            if (ch3 == ch1) {
                state = check(A, B, C, n - 1, m, index - 1, dp);
            } else {
                state = false;
            }
        }
        if (!state && index >= 0 && m >= 0) {
            char ch2 = B.charAt(m);
            char ch3 = C.charAt(index);
            if (ch3 == ch2) {
                state = check(A, B, C, n, m - 1, index - 1, dp);
            } else {
                state = false;
            }
        }
        dp[n+1][m+1] = state ? 1 : 0;
        return state;
    }
}