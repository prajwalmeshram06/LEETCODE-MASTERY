class Solution {
    static final class DSU {
        private final int[] parent;
        private final int[] rank;
        private int components;

        DSU(int size) {
            if (size < 0) {
                throw new IllegalArgumentException("Size cannot be negative.");
            }

            parent = new int[size];
            rank = new int[size];
            components = size;

            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression.
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return false;
            }

            // Union by rank keeps the trees shallow.
            if (rank[rootA] < rank[rootB]) {
                parent[rootA] = rootB;
            } else if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootB] = rootA;
                rank[rootA]++;
            }

            components--;
            return true;
        }

        int components() {
            return components;
        }
    }

    static int Kruskal(int[][] edges, int n) {
        int minCost = Integer.MAX_VALUE;
        DSU d = new DSU(n + 1);

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            d.union(u, v);
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if(d.find(u) == d.find(1)) {
                minCost = Math.min(minCost, wt);
            }
        }

        return minCost;
    }
    public int minScore(int n, int[][] roads) {
        return Kruskal(roads ,n);
    }
}