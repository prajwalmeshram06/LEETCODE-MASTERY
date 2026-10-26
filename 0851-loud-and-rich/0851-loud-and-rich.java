class Solution {
    static int[] kahnsAlgorithm(List<List<Integer>> graph) {
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

        int[] order = new int[vertices];
        int k = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            order[k++] = u;

            for (int v : graph.get(u)) {
                if (--inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return order.length == vertices ? order : new int[]{};
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] person : richer) {
            int a = person[0];
            int b = person[1];

            graph.get(b).add(a);
        }

        int[] topo = kahnsAlgorithm(graph);
        int[] ans = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            int x = topo[i];
            int q = quiet[x];
            ans[x] = x;

            for(int y : graph.get(x)) {
                if(q >= quiet[ans[y]]) {
                    ans[x] = ans[y];
                    q = quiet[ans[y]];
                }
            }
        }

        return ans;
    }
}