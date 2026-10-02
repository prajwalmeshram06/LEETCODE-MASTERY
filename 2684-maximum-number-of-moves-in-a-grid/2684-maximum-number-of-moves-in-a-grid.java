class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxStep = 1;

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for(int j = 1; j < n; j++) {
            for(int i = 0; i < m; i++) {

                if(i > 0 && dp[i - 1][j - 1] != 0  && grid[i][j] > grid[i - 1][j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }

                if(dp[i][j - 1] != 0 && grid[i][j] > grid[i][j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                }

                if(i < m - 1 && dp[i + 1][j - 1] != 0 && grid[i][j] > grid[i + 1][j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                }

                maxStep = Math.max(maxStep, dp[i][j]);
            }
        }

        return maxStep - 1;
    }
}