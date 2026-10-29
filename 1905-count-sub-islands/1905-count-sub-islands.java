class Solution {
    int[] dr = new int[]{-1, 0, 0, 1};
    int[] dc = new int[]{0, -1, 1, 0};

    public void DFS(int sr, int sc, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        grid[sr][sc] = 0;
        visited[sr][sc] = true;

        for(int i = 0; i < 4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && grid[nr][nc] == 1) {
                DFS(nr, nc, grid, visited);
            }
        }

    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        
        int subIslands = 0;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid1[i][j] == 0 && grid2[i][j] == 1 && !visited[i][j]) {
                    DFS(i, j, grid2, visited);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid1[i][j] == 1 && grid2[i][j] == 1 && !visited[i][j]) {
                    subIslands++;
                    DFS(i, j, grid2, visited);
                }
            }
        }

        return subIslands;
        
    }
}