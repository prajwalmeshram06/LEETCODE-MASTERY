class Solution {
    public int detectCycle(List<List<Integer>> graph) {
        int vertices = graph.size();
        int shortest = Integer.MAX_VALUE;

        for (int start = 0; start < vertices; start++) {
            boolean[] visited = new boolean[vertices];
            int[] dist = new int[vertices];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{start, -1});
            visited[start] = true;
            dist[start] = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int u = current[0];
                int parent = current[1];

                for (int v : graph.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.offer(new int[]{v, u});
                        dist[v] = dist[u] + 1;
                    } else if (v != parent) {
                        shortest = Math.min(shortest, dist[v] + dist[u] + 1);
                    }
                }
            }
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
    public int findShortestCycle(int n, int[][] edges) {
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

        return detectCycle(graph);
    }
}