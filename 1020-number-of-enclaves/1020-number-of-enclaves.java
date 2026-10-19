class Solution {
    public void DFS(int sr, int sc, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        visited[sr][sc] = true;

        int[] dr = new int[]{-1, 0, 0, 1};
        int[] dc = new int[]{0, -1, 1, 0};

        for(int i = 0; i < 4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && !visited[nr][nc]) {
                DFS(nr, nc, grid, visited);
            }
        } 
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            if(grid[i][0] == 1) {
                DFS(i, 0, grid, visited);
            }


            if(grid[i][m - 1] == 1) {
                DFS(i, m - 1, grid, visited);
            }
        }
        for(int i = 0; i < m; i++) {
            if(grid[0][i] == 1) {
                DFS(0, i, grid, visited);
            }


            if(grid[n - 1][i] == 1) {
                DFS(n - 1, i, grid, visited);
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    ans++;
                }
            }
        }

        return ans;
    }
}