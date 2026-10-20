class Solution {

    int MOD = 1_000_000_007;

    int[] dr = new int[]{-1, 0, 0, 1};
    int[] dc = new int[]{0, -1, 1, 0};

    public int DFS(int sr, int sc, int[][] grid, int[][] dp) {

        if(dp[sr][sc] != 0) {
            return dp[sr][sc];
        }

        int count = 1;

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < 4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[sr][sc] > grid[nr][nc]) {
                count  = (count + DFS(nr, nc, grid, dp)) % MOD;
            }
        }

        return dp[sr][sc] = count;

    }
    public int countPaths(int[][] grid) {

        int paths = 0;

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                paths = (paths + DFS(i, j, grid, dp)) % MOD;
            }
        }

        return paths;

    }
}