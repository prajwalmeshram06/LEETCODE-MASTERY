class Solution {
    public long DFS(int u, long[] cnt, List<List<Integer>> graph, boolean[] visited) {
        long cc = 1;
        visited[u] = true;

        for(int v : graph.get(u)) {
            if(!visited[v]) {
                cc += DFS(v, cnt, graph, visited);
            }
        }

        return cnt[u] = cc;
    }
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        List<Long> sizes = new ArrayList<>();

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        long[] cnt = new long[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
               long size = DFS(i, cnt, graph, visited);
               sizes.add(size);
            } 
        }

        long pairs = 0;
        long remaining = n;

        for(long size : sizes) {
            remaining -= size;
            pairs += size * remaining;
        }

        return pairs;
    }
}