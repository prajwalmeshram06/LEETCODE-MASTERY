class Solution {

    int[] dr = new int[]{-1, 0, 0, 1};
    int[] dc = new int[]{0, -1, 1, 0};

    public int minimumEffortPath(int[][] h) {
        int n = h.length;
        int m = h[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.offer(new int[]{0, 0, 0});
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int d = top[0];
            int sr = top[1];
            int sc = top[2];

            if (d > dist[sr][sc]) {
                continue;
            }

            if (sr == n - 1 && sc == m - 1) {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int nr = sr + dr[i];
                int nc = sc + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                    continue;
                }

                int nd = Math.max(d, Math.abs(h[sr][sc] - h[nr][nc]));

                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd;
                    pq.offer(new int[]{nd, nr, nc});
                }
            }
        }

        return 0;
    }
}