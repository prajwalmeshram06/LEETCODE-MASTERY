
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] dr = new int[]{-1, 0, 0, 1};
        int[] dc = new int[]{0, -1, 1, 0};

        int[][] time = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        time[0][0] = grid[0][0];
        pq.offer(new int[]{0, 0, time[0][0]});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int sr = top[0];
            int sc = top[1];
            int t = top[2];

            if (time[sr][sc] > t) continue;

            if (sr == n - 1 && sc == m - 1) return t;

            for (int i = 0; i < 4; i++) {
                int nr = sr + dr[i];
                int nc = sc + dc[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

                int newTime = Math.max(t, grid[nr][nc]);

                if (newTime < time[nr][nc]) {
                    time[nr][nc] = newTime;
                    pq.offer(new int[]{nr, nc, newTime});
                }
            }
        }

        return time[n - 1][m - 1];
    }
}
