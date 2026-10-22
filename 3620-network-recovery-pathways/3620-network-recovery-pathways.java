
import java.util.*;

class Solution {

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        int maxCost = 0;

        for (int[] edge : edges) {
            maxCost = Math.max(maxCost, edge[2]);
        }

        int lo = 0;
        int hi = maxCost;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (check(mid, n, edges, online, k)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    public boolean check(int limit, int n, int[][] edges, boolean[] online, long k) {

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean updated = false;

            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (w < limit) {
                    continue;
                }

                if (dist[u] == Long.MAX_VALUE) {
                    continue;
                }

                if (u != 0 && u != n - 1 && !online[u]) {
                    continue;
                }

                if (v != n - 1 && !online[v]) {
                    continue;
                }

                long nd = dist[u] + w;

                if (nd < dist[v]) {
                    dist[v] = nd;
                    updated = true;
                }
            }

            if (!updated) {
                break;
            }
        }

        return dist[n - 1] <= k;
    }
}
