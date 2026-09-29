class Solution {
    public int minPathSum(int[][] banana) {
        int m = banana.length;
        int n = banana[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = banana[0][0];

        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + banana[0][j];
        }

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + banana[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = banana[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m - 1][n - 1];
    }
}