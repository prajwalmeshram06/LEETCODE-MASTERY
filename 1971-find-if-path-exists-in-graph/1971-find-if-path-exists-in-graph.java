class Solution {

    public boolean DFS(List<List<Integer>> graph, boolean[] visited, int u, int d) {
        visited[u] = true;

        boolean isValid = false;

        for(int v : graph.get(u)) {
            if(v == d || isValid) return true;

            if(!visited[v]) {
                isValid = DFS(graph, visited, v, d);
            }
        }

        return isValid;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if(source == destination) return true;
        
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];

        return DFS(graph, visited, source, destination);
    }
}