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
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return false;
            }

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

    static int Kruskal(int[][] edges, int n) {
        int minCost = 0;
        DSU d = new DSU(n);

        Arrays.sort(edges, (a,b)-> Integer.compare(a[2], b[2]));

        for(int[] edge : edges) {

            if(d.components() == 1) break;

            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if(!d.union(u, v)) {
                continue;
            }

            minCost += wt;
        }

        return minCost;
    }


    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] edges = new int[(n * (n - 1)) / 2][3];
        int k = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(i == j) continue;

                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                int val = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                edges[k][0] = i;
                edges[k][1] = j;
                edges[k][2] = val;
                k++;
            }
        }

        return Kruskal(edges, n);
    }
}