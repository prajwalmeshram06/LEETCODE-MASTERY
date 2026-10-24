class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] indegree = new int[n];

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];

            indegree[u]++;
            indegree[v]++;
        }

        int[][] sortable = new int[n][2];

        for (int i = 0; i < n; i++) {
            sortable[i][0] = indegree[i];
            sortable[i][1] = i;
        }

        Arrays.sort(sortable, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        long maxImportance = 0;

        for (int i = 0; i < n; i++) {
            maxImportance += (long) (i + 1) * sortable[i][0];
        }

        return maxImportance;
    }
}