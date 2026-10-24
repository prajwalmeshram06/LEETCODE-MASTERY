class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] inDegree = new int[n];

        for(int i = 0; i < edges.length; i++) {
            inDegree[edges[i][1]]++;
        }

        int ans = -1;
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                cnt++;
                ans = i;
            }
        }

        return cnt == 1 ? ans : -1;
    }
}