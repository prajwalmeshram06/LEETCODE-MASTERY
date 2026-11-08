class Solution {
    public int DFS(List<List<Integer>> graph, boolean[] visited, int u) {
        visited[u] = true;
        int len = 1;

        for(int v : graph.get(u)) {
            if(!visited[v]) {
                len += DFS(graph, visited, v);
            }
        }

        return len;
    }
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {

                if(i == j) continue;

                long x1 = bombs[i][0];
                long y1 = bombs[i][1];
                long r1 = bombs[i][2];

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long dx = x2 - x1;
                long dy = y2 - y1;

                if(dx * dx + dy * dy <= r1 * r1) {
                    graph.get(i).add(j);
                }
            }
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];

            int b = DFS(graph, visited, i);
            ans = Math.max(ans, b);
        }

        return ans;
    }
}