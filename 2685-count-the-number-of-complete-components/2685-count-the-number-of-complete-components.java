class Solution {
    public void DFS(int u, List<List<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[u] = true;
        component.add(u);

        for(int v : graph.get(u)) {
            if(!visited[v]) {
                DFS(v, graph, visited, component);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        int ans = 0;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int w = edges[i][1];

            graph.get(u).add(w);
            graph.get(w).add(u);
        }

        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                List<Integer> component = new ArrayList<>();

                DFS(i, graph, visited, component);

                int count = component.size();
                boolean complete = true;

                for(int node : component) {
                    if(graph.get(node).size() != count - 1) {
                        complete = false;
                        break;
                    }
                }

                if(complete) {
                    ans++;
                }
            }
        }

        return ans;
    }
}