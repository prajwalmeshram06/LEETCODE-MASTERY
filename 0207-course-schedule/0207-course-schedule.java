class Solution {
    static boolean detectCycleD(List<List<Integer>> graph, boolean[] visited, boolean[] recPath, int curr) {

        visited[curr] = true;
        recPath[curr] = true;

        for (int v : graph.get(curr)) {
            if (!visited[v]) {
                if (detectCycleD(graph, visited, recPath, v)) {
                    return true;
                }
            } else if (recPath[v]) {
                return true;
            }
        }

        recPath[curr] = false;
        return false;
    }
    static boolean hasCycleDirected(List<List<Integer>> graph, int n) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        boolean[] recPath = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycleD(graph, visited, recPath, i)) {
                    return true;
                }
            }
        }

        return false;
    }
    public boolean canFinish(int n, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] curr : prerequisites) {
            int u = curr[0];
            int v = curr[1];

            graph.get(u).add(v);
        }

        if(hasCycleDirected(graph, n)) {
            return false;
        } else {
            return true;
        }


    }
}