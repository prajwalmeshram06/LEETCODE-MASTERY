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


    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int n2 = 0;
        int n3 = 0;
        int n1 = 0;

        int used = 0;

        DSU d1 = new DSU(n + 1);
        DSU d2 = new DSU(n + 1);

       for (int[] edge : edges) {
            if (edge[0] == 3) {
                int u = edge[1];
                int v = edge[2];

                boolean alice = d1.union(u, v);
                boolean bob = d2.union(u, v);

                if (alice || bob) {
                    used++;
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[1];
            int v = edge[2];
            int wt = edge[0];

            if (wt == 1 && d1.union(u, v)) {
                used++;
            } else if (wt == 2 && d2.union(u, v)) {
                used++;
            }
        }

        if(d2.components() != 2 || d1.components() != 2) {
            return -1;
        }

        return edges.length - used;
    }
}