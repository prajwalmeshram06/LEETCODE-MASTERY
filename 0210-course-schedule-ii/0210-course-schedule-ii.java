class Solution {

    static void sort(int u, boolean[] visited, Stack<Integer> s, List<List<Integer>> graph) {

        visited[u] = true;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                sort(v, visited, s, graph);
            }
        }

        s.push(u);
    }

    static int[] topologicalSort(List<List<Integer>> graph) {
        int V = graph.size();
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                sort(i, visited, s, graph);
            }
        }

        int n = s.size();
        int[] ans = new int[n];
        int k = 0;

        while (!s.isEmpty()) {
            int x = s.pop();
            ans[k++] = x;
        }

        return ans;
    }

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

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];

        if(canFinish(numCourses, prerequisites)) {

            List<List<Integer>> graph = new ArrayList<>();

            for(int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            for(int[] curr : prerequisites) {
                int u = curr[0];
                int v = curr[1];

                graph.get(v).add(u);
            }

            ans = topologicalSort(graph);

            return ans;
        } else {
            return new int[]{};
        }
    }
}