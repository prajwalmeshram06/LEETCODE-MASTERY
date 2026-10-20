class Solution {
    int[] dr = new int[]{-1, 0, 0, 1};
    int[] dc = new int[]{0, -1, 1, 0};

    public int DFS(int sr, int sc, int[][] grid, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        int fishes = grid[sr][sc];
        visited[sr][sc] = true;

        for(int i = 0; i < 4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && grid[nr][nc] > 0) {
                visited[nr][nc] = true;
                fishes += DFS(nr, nc, grid, visited);
            }
        }

        return fishes;
    }
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length; 

        boolean[][] visited = new boolean[n][m];

        int maxFishes = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j] > 0) {
                    maxFishes = Math.max(maxFishes, DFS(i, j, grid, visited));
                }
            }
        }

        return maxFishes;
    }
}