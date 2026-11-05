class Solution {
    int time = 0;

    public void DFS(int u, boolean[] visited, int parent, int[] dis, int[] low, List<List<Integer>> graph, List<List<Integer>> ans) {
        visited[u] = true;
        low[u] = ++time;
        dis[u] = low[u];

        for(int v : graph.get(u)) {
            if(!visited[v]) {
                DFS(v, visited, u, dis, low, graph, ans);

                low[u] = Math.min(low[u], low[v]);

                if(low[v] > dis[u]) {
                    List<Integer> edge = new ArrayList<>();
                    edge.add(u);
                    edge.add(v);
                    ans.add(edge);
                }
            } 
            else {
                if(v != parent) {
                    low[u] = Math.min(low[u], dis[v]);
                }
            }
        } 
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[] dis = new int[n];
        int[] low = new int[n];

        boolean[] visited = new boolean[n];

        for(int i = 0; i < connections.size(); i++) {
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                DFS(i, visited, -1, dis, low, graph, ans);
            }
        }

        return ans;
    }
}