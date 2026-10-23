class Solution {
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int minDel = 0;

        Deque<int[]> dq = new ArrayDeque<>();
        int[][] dist = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dq.offer(new int[]{0, 0, grid[0][0]});
        dist[0][0] = 0;

        int[] dr = new int[]{-1, 0, 0, 1};
        int[] dc = new int[]{0, -1, 1, 0};
        
        while(!dq.isEmpty()) {
            int[] top = dq.poll();
            int sr = top[0];
            int sc = top[1];
            int del = top[2];

            for (int i = 0; i < 4; i++) {
                int nr = sr + dr[i];
                int nc = sc + dc[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }
                int newDel = del + grid[nr][nc];

                if(dist[nr][nc] > newDel) {
                    dist[nr][nc] = newDel;
                    if(grid[nr][nc] == 0) {
                        dq.offerFirst(new int[]{nr, nc, newDel});
                    } else {
                        dq.offerLast(new int[]{nr, nc, newDel});
                    }
                }

               
            }
        }
        return dist[n - 1][m - 1];
    }
}