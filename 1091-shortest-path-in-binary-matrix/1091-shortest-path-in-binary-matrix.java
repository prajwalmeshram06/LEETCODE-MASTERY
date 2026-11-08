class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1;

        int[] dr = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = new int[]{-1, 0, 1, -1, 1, 1, 0, -1};

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int sr = curr[0];
            int sc = curr[1];
            int d = curr[2];

            if(sr == n - 1 && sc == m - 1) return d;

            for(int i = 0; i < 8; i++) {
                int nr = sr + dr[i];
                int nc = sc + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc] && grid[nr][nc] == 0) {
                    if(nr == n - 1 && nc == m - 1) return d + 1;
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, d + 1});
                }
            }
        }

        return -1;
    }
}