class Solution {

    int[] dr = new int[]{-1, 0, 0, 1};
    int[] dc = new int[]{0, -1, 1, 0};

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dist = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        if(q.isEmpty() || q.size() == n * m) return -1;

        while(!q.isEmpty()) {
            int[] c = q.poll();
            int sr = c[0];
            int sc = c[1];
            int d = c[2];

            for(int i = 0; i < 4; i++) {
                int nr = sr + dr[i];
                int nc = sc + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1;
                    q.offer(new int[]{nr, nc, d + 1});
                    dist = Math.max(d + 1, dist);
                }
            }
        }

        return dist;

    }
}