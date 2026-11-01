class Solution {
    public int minActivationCost(int[][] edges, int[] values) {
        long INF = (long) 1e18;
        long ans = INF;

        int n = values.length;
        long[] best = new long[n];

        Arrays.fill(best, INF);

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            long w = e[2];

            int pu = Integer.bitCount(values[u]) % 2;
            int pv = Integer.bitCount(values[v]) % 2;

            if (pu == pv) {
                ans = Math.min(ans, w);
            } else {
                int zero_node = (pu == 0) ? u : v;

                ans = Math.min(ans, best[zero_node] + w);
                best[zero_node] = Math.min(best[zero_node], w);
            }
        }

        return ans >= INF ? -1 : (int) ans;
    }
}