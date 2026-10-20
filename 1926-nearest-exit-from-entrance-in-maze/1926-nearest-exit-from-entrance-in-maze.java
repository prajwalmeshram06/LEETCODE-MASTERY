class Solution {
    int[] dr = new int[]{-1, 0, 0, 1};
    int[] dc = new int[]{0, -1, 1, 0};

    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        int x = entrance[0];
        int y = entrance[1];

        int minDist = Integer.MAX_VALUE;

        q.offer(new int[]{x, y, 0});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] c = q.poll();
            int sr = c[0];
            int sc = c[1];
            int dist = c[2];

            if ((sr == 0 || sr == n - 1 || sc == 0 || sc == m - 1) && !(sr == x && sc == y)) {
                return dist;
            }

            for(int i = 0; i < 4; i++) {
                int nr = sr + dr[i];
                int nc = sc + dc[i];

                if(nr < n && nr >= 0 && nc < m && nc >= 0 && maze[nr][nc] != '+' && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, dist + 1});
                } 
            }
        }
        
        return -1;
    }
}