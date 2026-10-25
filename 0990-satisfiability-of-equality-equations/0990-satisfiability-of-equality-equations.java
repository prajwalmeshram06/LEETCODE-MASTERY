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

    public boolean equationsPossible(String[] equations) {
        DSU d = new DSU(26);

        for(String s : equations) {
            if(s.charAt(1) == '=') d.union(s.charAt(0) - 'a', s.charAt(3) - 'a');
        }

        for(String s : equations) {
            if(s.charAt(1) == '!' && (d.find(s.charAt(0) - 'a') == d.find(s.charAt(3) - 'a'))) return false;
        }

        return true;
    }
}