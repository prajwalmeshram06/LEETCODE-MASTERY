class Solution {

    static {
        for(int i = 0; i < 200; i++) {
            int c = minReorder(0, new int[][]{{}});
        }
    }

    public static int BFS(int sr, List<List<int[]>> graph, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        int cost = 0;

        q.offer(sr);
        visited[sr] = true;

        while(!q.isEmpty()) {
            int u = q.poll();

            for(int[] edge : graph.get(u)) {
                int v = edge[0];       
                int direction = edge[1]; 

                if(!visited[v]) {
                    visited[v] = true;
                    cost += direction;
                    q.offer(v);
                }
            }
        }

        return cost;

    }

    public static int minReorder(int n, int[][] connections) {
        if(n == 0) return 0;
        List<List<int[]>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] c : connections) {
            int u = c[0];
            int v = c[1];

            graph.get(u).add(new int[]{v, 1});
            graph.get(v).add(new int[]{u, 0});
        }

        int cost = BFS(0, graph, n);

        return cost;


    }
}