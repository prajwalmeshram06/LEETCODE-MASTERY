class Solution {
    int[] dr = new int[]{-1, 0, 0, 1};
    int[] dc = new int[]{0, -1, 1, 0};

    public int DFS(int[][] grid, int sr, int sc, int[][] dp) {
        int n = grid.length; 
        int m = grid[0].length;

        if(dp[sr][sc] != -1) {
            return dp[sr][sc];
        }

        int len = 1;
        for(int i = 0; i < 4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && (grid[nr][nc] > grid[sr][sc])) {
                len = Math.max(len, 1 + DFS(grid, nr, nc, dp));
            }
        }

        return dp[sr][sc] = len;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int len = DFS(matrix, i, j, dp);
                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}