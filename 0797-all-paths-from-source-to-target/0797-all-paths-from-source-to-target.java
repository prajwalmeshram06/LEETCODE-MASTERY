class Solution {
    static List<ArrayList<Integer>> arrayToList(int[][] graph) {
        List<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            ArrayList<Integer> neighbours = new ArrayList<>();

            for (int v : graph[i]) {
                neighbours.add(v);
            }

            adj.add(neighbours);
        }

        return adj;
    }
    public void DFS(int u, List<ArrayList<Integer>> graph, List<List<Integer>> paths, List<Integer> cPath) {
        
        cPath.add(u);
        if (u == graph.size() - 1) {
            paths.add(new ArrayList<>(cPath));
            cPath.remove(cPath.size() - 1);
            return;
        }

        for (int v : graph.get(u)) {
            DFS(v, graph, paths, cPath);
        }

        cPath.remove(cPath.size() - 1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<ArrayList<Integer>> adj = arrayToList(graph);
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> cPath = new ArrayList<>();

        DFS(0, adj, paths, cPath);
        return paths;
    }
}