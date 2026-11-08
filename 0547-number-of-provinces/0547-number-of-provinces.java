class Solution {
    class DSU {
        int component;
        int[] rank;
        int[] parent;

        DSU(int n) {
            rank = new int[n];
            parent = new int[n];

            component = n;

            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if(parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        public boolean union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if(rootA == rootB) {
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

            component--;
            return true;
        }

        public int components() {
            return component;
        }
    }


    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        DSU d = new DSU(n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(isConnected[i][j] == 1) {
                    d.union(i, j);
                }
            }
        }

        return d.components();
    }
}