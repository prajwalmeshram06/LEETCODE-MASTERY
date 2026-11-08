class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] connected = new boolean[n][n];
        int[] indegree = new int[n];
        int[] outdegree = new int[n];

        for(int[] road : roads) {
            int u = road[0];
            int v = road[1];

            connected[u][v] = true;
            connected[v][u] = true;

            indegree[u]++;
            indegree[v]++;
            outdegree[u]++;
            outdegree[v]++;
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                ans = Math.max(ans, indegree[i] + indegree[j] - (connected[i][j] == true ? 1 : 0));
            }
        }

        return ans;
    }
}