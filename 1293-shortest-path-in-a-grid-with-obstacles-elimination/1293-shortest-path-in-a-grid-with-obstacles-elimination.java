class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        if (n == 1 && m == 1) return 0;

        int[] dr = new int[]{-1, 0, 0, 1};
        int[] dc = new int[]{0, -1, 1, 0};

        boolean[][][] visited = new boolean[n][m][k + 1];

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] top = q.poll();

            int sr = top[0];
            int sc = top[1];
            int p = top[2];
            int step = top[3];

            if (sr == n - 1 && sc == m - 1) {
                return step;
            }

            for (int i = 0; i < 4; i++) {
                int nr = sr + dr[i];
                int nc = sc + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }

                int newP = p + grid[nr][nc];

                if (newP > k || visited[nr][nc][newP]) {
                    continue;
                }

                visited[nr][nc][newP] = true;
                q.offer(new int[]{nr, nc, newP, step + 1});
            }
        }

        return -1;
    }
}