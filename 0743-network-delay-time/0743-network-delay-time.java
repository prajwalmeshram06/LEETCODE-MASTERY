class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int t = edge[2];

            graph.get(u).add(new int[]{v, t});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> 
            Integer.compare(a[1], b[1])
        );

        pq.offer(new int[]{k, 0});

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int cDist = curr[1];

            if(cDist != dist[u]) continue;

            for(int[] next : graph.get(u)) {
                int v = next[0];
                int d = next[1];

                int nDist = cDist + d;

                if(nDist < dist[v]) {
                    dist[v] = nDist;
                    pq.offer(new int[]{v, nDist});
                }
            }
        }

        int ans = 0;

        for(int i = 1; i <= n; i++) {
            if(dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }

        return ans;
        
       
    }
}