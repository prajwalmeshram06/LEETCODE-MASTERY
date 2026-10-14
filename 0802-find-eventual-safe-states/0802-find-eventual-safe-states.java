class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        int V = graph.length;

        List<ArrayList<Integer>> reverseGraph = new ArrayList<>();
        int[] outDegree = new int[V];

        for (int i = 0; i < V; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        for (int u = 0; u < V; u++) {
            outDegree[u] = graph[u].length;

            for (int v : graph[u]) {
                reverseGraph.get(v).add(u);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (outDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            ans.add(u);

            for (int v : reverseGraph.get(u)) {
                outDegree[v]--;

                if (outDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        Collections.sort(ans);
        return ans;
    }
}