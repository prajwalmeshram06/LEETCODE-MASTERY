
class Solution {

    public void DFS(int r, int c, char[][] grid, boolean[][] visited, char[][] ans) {
        int n = grid.length;
        int m = grid[0].length;

        visited[r][c] = true;
        ans[r][c] = 'O';

        int[] dr = new int[]{1, 0, 0, -1};
        int[] dc = new int[]{0, 1, -1, 0};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                grid[nr][nc] == 'O' && !visited[nr][nc]) {
                DFS(nr, nc, grid, visited, ans);
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] visited = new boolean[n][m];
        char[][] ans = new char[n][m];

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                DFS(i, 0, board, visited, ans);
            }

            if (board[i][m - 1] == 'O' && !visited[i][m - 1]) {
                DFS(i, m - 1, board, visited, ans);
            }
        }

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                DFS(0, j, board, visited, ans);
            }

            if (board[n - 1][j] == 'O' && !visited[n - 1][j]) {
                DFS(n - 1, j, board, visited, ans);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    ans[i][j] = 'X';
                } else if (!visited[i][j]) {
                    ans[i][j] = 'X';
                } else {
                    ans[i][j] = 'O';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = ans[i][j];
            }
        }
    }
}
