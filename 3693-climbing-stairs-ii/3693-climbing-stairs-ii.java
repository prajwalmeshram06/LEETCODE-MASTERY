class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];

        dp[0] = 0;

        dp[1] = costs[0] + 1;

        if(n >= 2) {
            dp[2] = Math.min(dp[1] + costs[1] + 1, dp[0] + costs[1] + 4);
        }

        for(int i = 3; i <= n; i++) {
            dp[i] = costs[i - 1] + Math.min(dp[i - 1] + 1, Math.min(dp[i - 2] + 4, dp[i - 3] + 9));
        }

        return dp[n];
    }
}