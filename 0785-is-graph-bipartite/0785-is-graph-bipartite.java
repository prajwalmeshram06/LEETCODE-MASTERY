class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colour = new int[n];
        Arrays.fill(colour, -1);

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            if(colour[i] == -1) {
                q.offer(i);
                colour[i] = 0;

                while(!q.isEmpty()) {
                    int u = q.poll();

                    for(int v : graph[u]) {
                        if(colour[v] == colour[u]) {
                            return false;
                        }

                        if (colour[v] == -1) {
                            colour[v] = 1 - colour[u];
                            q.offer(v);
                        }
                    }
                }
            }
        }
        return true;

    }
}