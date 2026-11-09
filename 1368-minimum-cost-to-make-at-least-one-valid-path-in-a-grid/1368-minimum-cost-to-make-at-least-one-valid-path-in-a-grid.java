class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0, 0, 0});
        dist[0][0] = 0;

        int[] dr = new int[]{0, 0, 1, -1};
        int[] dc = new int[]{1, -1, 0, 0};

        while(!dq.isEmpty()) {
            int[] curr = dq.poll();
            int sr = curr[0];
            int sc = curr[1];
            int cost = curr[2];

            if(cost > dist[sr][sc]) continue;

            if(sr == n - 1 && sc == m - 1) return cost;

            for(int i = 0; i < 4; i++) {
                int nr = sr + dr[i];
                int nc = sc + dc[i];

                if(nr >= n || nr < 0 || nc >= m || nc < 0) continue;

                int c = grid[sr][sc] == 1 + i ? 0 : 1;

                if(c + dist[sr][sc] < dist[nr][nc]) {
                    dist[nr][nc] = c + dist[sr][sc];
                    if(c == 0) dq.offerFirst(new int[]{nr, nc, dist[nr][nc]});
                    else dq.offerLast(new int[]{nr, nc, dist[nr][nc]});
                } 
            }
        }

        return -1;
    }
}