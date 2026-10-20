class Solution {

    int[] dr = new int[]{-1, 0, 0, 1};
    int[] dc = new int[]{0, -1, 1, 0};

    public int DFS(int sr, int sc, int[][] grid, boolean[][] visited) {
       int n = grid.length;
       int m = grid[0].length; 
       int area = 1;

       for(int i = 0; i < 4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1 && !visited[nr][nc]) {
                visited[nr][nc] = true;
                area += DFS(nr, nc, grid, visited);
            }
       }

       return area;

    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    maxArea = Math.max(maxArea, DFS(i, j, grid, visited));
                }
            }
        }

        return maxArea;
    }
}