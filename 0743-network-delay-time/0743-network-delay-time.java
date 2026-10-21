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

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] t : times) {
            int u = t[0];
            int v = t[1];
            int w = t[2];

            graph.get(u).add(new int[]{v, w});
        }

        List<Integer> minimumTime = dijkstra(graph, k);

        int delay = 0;

        for (int i = 1; i <= n; i++) {
            int time = minimumTime.get(i);

            if (time == Integer.MAX_VALUE) {
                return -1;
            }

            delay = Math.max(delay, time);
        }

        return delay;
    }
}