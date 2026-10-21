class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : dislikes) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                q.offer(i);
                color[i] = 0;

                while (!q.isEmpty()) {
                    int u = q.poll();

                    for (int v : graph.get(u)) {
                        if (color[v] == color[u]) {
                            return false;
                        }

                        if (color[v] == -1) {
                            color[v] = 1 - color[u];
                            q.offer(v);
                        }
                    }
                }
            }
        }

        return true;
    }
}