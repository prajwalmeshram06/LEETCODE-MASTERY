class Solution {
    // static {
    //     for(int i = 0; i < 200; i++) {
    //         minimumTime(0, new int[][]{{}}, new int[]{});
    //     }
    // }
    static List<Integer> kahnsAlgorithm(List<List<Integer>> graph) {
        int vertices = graph.size();
        int[] inDegree = new int[vertices];

        for (List<Integer> neighbors : graph) {
            for (int v : neighbors) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < vertices; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>(vertices);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);

            for (int v : graph.get(u)) {
                if (--inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return order.size() == vertices ? order : Collections.emptyList();
    }

    public static int minimumTime(int n, int[][] relations, int[] time) {
        if(n == 0) return 0;
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : relations) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
        }

        List<Integer> order = kahnsAlgorithm(graph);

        int[] finish = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            finish[i] = time[i - 1];
        }

        int totalTime = 0;

        for(int u : order) {
            for(int v : graph.get(u)) {
                finish[v] = Math.max(finish[v], finish[u] + time[v - 1]);
            }
            totalTime = Math.max(totalTime, finish[u]);
        }

        return totalTime;
    }
}