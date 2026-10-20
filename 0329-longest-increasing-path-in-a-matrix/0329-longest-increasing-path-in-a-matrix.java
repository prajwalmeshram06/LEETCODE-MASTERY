class Solution {
    public int DFS(int sr, int sc, int[][] grid, int[][] dp) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dr = new int[]{-1, 0, 0, 1};
        int[] dc = new int[]{0, -1, 1, 0};

        int maxCount = 1;

        if(dp[sr][sc] != 0) {
            return dp[sr][sc];
        } else {
            for (int i = 0; i < 4; i++) {
                int nr = sr + dr[i];
                int nc = sc + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[sr][sc] < grid[nr][nc]) {
                    maxCount = Math.max(maxCount, 1 + DFS(nr, nc, grid, dp));
                }
            }
        }

        dp[sr][sc] = maxCount;

        return maxCount;
    }

    public int longestIncreasingPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxLen = 1;
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int len = DFS(i, j, grid, dp);
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }
}