
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] temp = new int[n];
        Arrays.fill(temp, Integer.MAX_VALUE);

        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int p = flight[2];

            graph.get(u).add(new int[]{v, p});
        }

        dist[src] = 0;

        for(int i = 0; i < k + 1; i++) {
            temp = dist.clone();

            for(int u = 0; u < n; u++) {
                for(int[] flight : graph.get(u)) {
                    int v = flight[0];
                    int p = flight[1];

                    if(dist[u] != Integer.MAX_VALUE &&
                       temp[v] > dist[u] + p) {
                        temp[v] = dist[u] + p;
                    }
                }
            }

            dist = temp;
        }

        return dist[dst] != Integer.MAX_VALUE ? dist[dst] : -1;
    }
}
