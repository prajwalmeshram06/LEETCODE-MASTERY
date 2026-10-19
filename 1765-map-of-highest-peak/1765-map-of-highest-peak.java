class Solution {
    public int[][] highestPeak(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] distance = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int[] dr = new int[]{1, 0, 0, -1};
        int[] dc = new int[]{0, 1, -1, 0};

        while(!q.isEmpty()) {
            int[] cr = q.poll();

            int r = cr[0];
            int c = cr[1];
            int dis = cr[2];

            distance[r][c] = dis;

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dis + 1});
                }
            }
        }

        return distance;
    }
}