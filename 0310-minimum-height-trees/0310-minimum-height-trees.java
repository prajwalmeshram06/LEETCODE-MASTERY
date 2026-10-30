class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Arrays.asList(0);

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            inDegree[v]++;
            graph.get(v).add(u);
            inDegree[u]++;
        }

        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 1) {
                q.offer(new int[]{i, 0});
                visited[i] = true;
            }
        }

        while(true) {

            List<Integer> ans = new ArrayList<>();
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int[] top = q.poll();
                int u = top[0];
                int ch = top[1];
                ans.add(u);

                for(int v : graph.get(u)) {
                    if((--inDegree[v]) == 1 && !visited[v]) {
                        visited[v] = true;
                        q.offer(new int[]{v, ch + 1});
                    }
                }
            }
            

            if(q.size() == 0) {
                return ans;
            }
        }
    }
}