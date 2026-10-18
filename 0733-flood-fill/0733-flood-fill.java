class Solution {
    public void DFS(int i, int j, boolean[][] visited, int[][] grid, int n, int m, int colour, int scol) {

        visited[i][j] = true;
        grid[i][j] = colour;

        if(j > 0 && !visited[i][j - 1] && grid[i][j - 1] == scol) {
             DFS(i, j - 1, visited, grid, n, m, colour, scol);
        }
        if(j < m - 1 && !visited[i][j + 1] && grid[i][j + 1] == scol) {
             DFS(i, j + 1, visited, grid, n, m, colour, scol);
        }
        if(i > 0 && !visited[i - 1][j] && grid[i - 1][j] == scol) {
             DFS(i - 1, j, visited, grid, n, m, colour, scol);
        }
        if(i < n - 1 && !visited[i + 1][j] && grid[i + 1][j] == scol) {
             DFS(i + 1, j, visited, grid, n, m, colour, scol);
        }
    } 

    public int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int scol = grid[sr][sc];
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        DFS(sr, sc, visited, grid, n, m, color, scol);

        return grid;
    }
}