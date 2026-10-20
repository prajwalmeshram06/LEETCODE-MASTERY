class Solution {

    public void DFS(int n, int u, List<List<Integer>> graph, boolean[] visited, List<List<Integer>> ans) {
        visited[u] = true;

        if (u != n) {
            ans.get(n).add(u);
        }

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                DFS(n, v, graph, visited, ans);
            }
        }
    }

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(v).add(u);
        }

        for (int i = 0; i < n; i++) {

            boolean[] visited = new boolean[n];

            DFS(i, i, graph, visited, ans);
            Collections.sort(ans.get(i));
        }

        return ans;
    }
}