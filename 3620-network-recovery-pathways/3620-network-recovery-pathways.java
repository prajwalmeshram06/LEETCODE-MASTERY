
import java.util.*;

class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<List<int[]>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        int maxCost = 0;

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int c = edge[2];

            graph.get(u).add(new int[]{v, c});
            indegree[v]++;

            maxCost = Math.max(maxCost, c);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!queue.isEmpty()) {
            int u = queue.poll();
            topo.add(u);

            for (int[] edge : graph.get(u)) {
                int v = edge[0];

                if (--indegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        int lo = 0;
        int hi = maxCost;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (check(mid, n, graph, topo, online, k)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    public boolean check(int limit, int n, List<List<int[]>> graph,
                         List<Integer> topo, boolean[] online, long k) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == Long.MAX_VALUE) {
                continue;
            }

            if (u != 0 && u != n - 1 && !online[u]) {
                continue;
            }

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int w = edge[1];

                if (w < limit) {
                    continue;
                }

                if (v != n - 1 && !online[v]) {
                    continue;
                }

                long nd = dist[u] + w;

                if (nd < dist[v]) {
                    dist[v] = nd;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}
