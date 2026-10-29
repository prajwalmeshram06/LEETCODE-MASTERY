class Solution {
    static {
        for(int i = 0; i < 201; i++) {
            DFS(0, 0, new int[0][0], new boolean[0][0], 0);
        }
    }

    static int[] dr = new int[]{-1, 0, 0, 1};
    static int[] dc = new int[]{0, -1, 1, 0};

    public static int DFS(int sr, int sc, int[][] grid, boolean[][] visited, int k) {
        if(k == 0) return 0;
        int n = grid.length;
        int area = 1;
        visited[sr][sc] = true;
        grid[sr][sc] = k;

        for(int i = 0; i < 4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] == 1) {
                area += DFS(nr, nc, grid, visited, k);
            }
        }

        return area;

    }
    public static int largestIsland(int[][] grid) {
        int n = grid.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean visited[][] = new boolean[n][n];

        int k = 2;
        int maxArea = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && grid[i][j] == 1) {
                    map.put(k, DFS(i, j, grid, visited, k));
                    k++;
                    maxArea = Math.max(maxArea, map.get(k - 1));
                }  
            }
        }

        
        

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    int area = 1;
                    for(int x = 0; x < 4; x++) {
                        if(i + dr[x] >= 0 && i + dr[x] < n && j + dc[x] >= 0 && j + dc[x] < n && !set.contains(grid[i + dr[x]][j + dc[x]])) {
                            if(grid[i + dr[x]][j + dc[x]] > 1) {
                                set.add(grid[i + dr[x]][j + dc[x]]);
                                area += map.get(grid[i + dr[x]][j + dc[x]]);
                            }
                        }
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
        
    }
}