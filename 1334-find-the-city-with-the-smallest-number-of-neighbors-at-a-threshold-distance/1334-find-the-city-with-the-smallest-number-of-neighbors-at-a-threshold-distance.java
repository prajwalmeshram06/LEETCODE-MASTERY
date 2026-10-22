class Solution {
    public List<Integer> dijkstra(List<List<int[]>> graph, int src) {
        int V = graph.size();

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        dist[src] = 0;
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();

            int d = top[0];
            int u = top[1];

            if (d > dist[u]) {
                continue;
            }

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int w = edge[1];

                if (w < 0) {
                    throw new IllegalArgumentException(
                        "Dijkstra requires non-negative edge weights."
                    );
                }

                if (d <= Integer.MAX_VALUE - w &&
                    d + w < dist[v]) {

                    dist[v] = d + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        List<Integer> result = new ArrayList<>(V);

        for (int d : dist) {
            result.add(d);
        }

        return result;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> graph = new ArrayList<>();

        int[] city = new int[n];

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int d = edges[i][2];

            graph.get(u).add(new int[]{v, d});
            graph.get(v).add(new int[]{u, d});

        }

        for(int i = 0; i < n; i++) {
            List<Integer> dist = dijkstra(graph, i);

            for(int j = 0; j < n; j++) {
                if(i != j && dist.get(j) <= distanceThreshold) {
                    city[i]++;
                }
            }
        }

        int ans = 0;
        int c = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            if(city[i] <= c) {
                c = city[i];
                ans = i;
            }
        }

        return ans;
    }
}