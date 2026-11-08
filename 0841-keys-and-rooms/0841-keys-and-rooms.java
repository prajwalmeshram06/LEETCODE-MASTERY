class Solution {
    public void DFS(List<List<Integer>> graph, boolean[] visited, int u) {
        visited[u] = true;

        for(int v : graph.get(u)) {
            if(!visited[v]) {
                DFS(graph, visited, v);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        visited[0] = true;
        DFS(rooms, visited, 0);

        for(int i = 0; i < n; i++) {
            if(!visited[i]) return false;
        }

        return true;
    }
}