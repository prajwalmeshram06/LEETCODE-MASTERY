class Solution {
    static void BFS(int st, List<ArrayList<Integer>> graph, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        visited[st] = true;
        q.offer(st);

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.offer(v);
                }
            }
        }
    }

    static List<ArrayList<Integer>> matrixToList(int[][] matrix) {
        int v = matrix.length;
        List<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (matrix[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        return graph;
    }

    public int findCircleNum(int[][] isConnected) {
        List<ArrayList<Integer>> graph = matrixToList(isConnected);

        boolean[] visited = new boolean[graph.size()];
        int ans = 0;

        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                ans++;
                BFS(i, graph, visited);
            }
        }

        return ans;
    }
}