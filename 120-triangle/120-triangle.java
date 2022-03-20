class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    dp[j] = triangle.get(i).get(j) + dp[j];
                } else {
                    dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j - 1]);
                }
            }
        }
        int ans = dp[0];
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[j]);
        }
        return ans;
        
    }
}