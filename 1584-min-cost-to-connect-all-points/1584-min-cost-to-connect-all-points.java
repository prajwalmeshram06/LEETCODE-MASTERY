class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> graph = new ArrayList<>();
        int n = points.length;

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) continue;

                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                int val = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                graph.get(i).add(new int[]{j, val});
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        boolean[] mst = new boolean[n];

        pq.offer(new int[]{0, 0});

        int minCost = 0;

        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            int u = top[0];
            int c = top[1];

            if(mst[u]) continue;
            mst[u] = true;
            minCost += c;

            for(int[] edge : graph.get(u)) {
                int v = edge[0];
                int cost = edge[1];

                if(mst[v]) continue;

                pq.offer(new int[]{v, cost});
            }
        }

        return minCost;
    }
}