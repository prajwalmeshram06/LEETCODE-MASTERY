class Solution {
    int nodes = 0;

    public int DFS(List<List<Integer>> graph, boolean[] visited, int u) {
        int m = 0;
        visited[u] = true;
        nodes++;

        for(int v : graph.get(u)) {
            m++;
            if(!visited[v]) {
                m += DFS(graph, visited, v);
            }
        }

        return m;
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int ccomp = 0;

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                nodes = 0;
                int m = DFS(graph, visited, i) / 2;
                if(m == (nodes * (nodes - 1)/2)) {
                    ccomp++;
                }
            }
        }

        return ccomp;
    }
}