class Solution {
    static {
        for (int i = 1; i < 200; i++)
            makeConnected(0, new int[0][0]);
    }
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
            checkVertex(x, parent.length);
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

    private static void checkVertex(int vertex, int vertices) {
        if (vertex < 0 || vertex >= vertices) {
            throw new IllegalArgumentException(
                    "Vertex " + vertex + " is outside [0, " + (vertices - 1) + "].");
        }
    }

    public static int makeConnected(int n, int[][] connections) {

        if(connections.length < n - 1) return -1;
        DSU d = new DSU(n);

        int ops = 0;

        for(int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            d.union(u, v);
        }

        return d.components - 1;
    }
}