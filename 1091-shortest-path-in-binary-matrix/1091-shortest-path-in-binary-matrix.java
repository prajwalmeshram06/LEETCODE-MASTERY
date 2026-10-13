class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[] dr = new int[] {-1, -1, -1, 0, 0, 1, 1, 1} ;
        int[] dc = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        q.offer(new int[] {0, 0, 1});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if(r == n - 1 && c == n - 1) {
                return dist;
            }

            for(int k = 0; k < 8; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if(nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[] {nr, nc, dist + 1});
                }
            }

        }
        return -1;
    }
}