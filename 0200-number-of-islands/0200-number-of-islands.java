class Solution {

    int[] dr = new int[]{-1, 0, 0, 1};
    int[] dc = new int[]{0, -1, 1, 0};

    public void DFS(char[][] grid, int sr, int sc) {
        int n = grid.length;
        int m = grid[0].length;

        grid[sr][sc] = '0';

        for(int i = 0; i < 4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1') {
                DFS(grid, nr, nc);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int islands = 0;

        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == '1') {
                    islands++;
                    DFS(grid, i, j);
                }
            }
        }

        return islands;
    }
}