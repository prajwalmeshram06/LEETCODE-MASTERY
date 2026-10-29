
class Solution {

    public void DFS(int src, List<List<Integer>> graph, boolean[] visited) {
        visited[src] = true;

        for (int v : graph.get(src)) {
            if (!visited[v]) {
                DFS(v, graph, visited);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
        }

        boolean[] visited = new boolean[n];

        DFS(k, graph, visited);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                for (int j : graph.get(i)) {
                    if (visited[j]) {
                        List<Integer> all = new ArrayList<>();

                        for (int x = 0; x < n; x++) {
                            all.add(x);
                        }

                        return all;
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}
