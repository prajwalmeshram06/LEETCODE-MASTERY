class Solution {
    public int minFallingPathSum(int[][] grid) {

        int n = grid.length;
        int[][] dp = new int[n + 1][n + 1];

        for(int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }

        for(int i = 1; i < n; i++) {

            int idx = -1;

            int min = Integer.MAX_VALUE;
            int min2 = Integer.MAX_VALUE;


            for(int j = 0; j < n; j++) {

                if(min > dp[i - 1][j]) {
                    min2 = min;
                    min = dp[i - 1][j];
                    idx = j;
                } else if(dp[i - 1][j] < min2) {
                    min2 = dp[i - 1][j];
                }

            }

            for(int j = 0; j < n; j++) {

                if(j != idx) {
                    dp[i][j] = min + grid[i][j];
                } else {
                    dp[i][j] = min2 + grid[i][j];
                }
                
            }
        }

        int minPath = dp[n - 1][0];

        for(int i = n - 1; i > 0; i--) {
            minPath = Math.min(minPath, dp[n - 1][i]);
        }

        return minPath;

    }
}