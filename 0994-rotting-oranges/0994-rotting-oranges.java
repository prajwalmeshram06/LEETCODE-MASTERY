class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int time = 0;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j, 0});
                }
            }
        }

        boolean[][] visited = new boolean[n][m];

        while(!q.isEmpty()) {
            int[] c = q.poll();

            int i = c[0];
            int j = c[1];
            int t = c[2];

            time = Math.max(time, t);

            if(i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == 1) {
                q.offer(new int[]{i-1, j, t + 1});
                grid[i - 1][j] = 2;
                visited[i - 1][j] = true;
            }
            if(i + 1 < n && !visited[i + 1][j] && grid[i + 1][j] == 1) {
                q.offer(new int[]{i+1, j, t + 1});
                grid[i + 1][j] = 2;
                visited[i + 1][j] = true;
            }
            if(j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == 1) {
                q.offer(new int[]{i, j - 1, t + 1});
                grid[i][j - 1] = 2;
                visited[i][j - 1] = true;
            }
            if(j + 1 < m && !visited[i][j + 1] && grid[i][j + 1] == 1) {
                q.offer(new int[]{i, j + 1, t + 1});
                grid[i][j + 1] = 2;
                visited[i][j + 1] = true;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    return -1;
                }
            }
        }

        return time;
    }
}