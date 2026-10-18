class Solution {

    public void DFS(int i, int j, boolean[][] visited, char[][] grid, int n, int m) {

        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        DFS(i, j - 1, visited, grid, n, m);
        DFS(i, j + 1, visited, grid, n, m);
        DFS(i - 1, j, visited, grid, n, m);
        DFS(i + 1, j, visited, grid, n, m);

    } 
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int islands = 0;

        boolean[][] visited = new boolean[n][m]; 

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    DFS(i, j, visited, grid, n, m);
                    islands++;
                }
            }
        }

        return islands;
    }
}