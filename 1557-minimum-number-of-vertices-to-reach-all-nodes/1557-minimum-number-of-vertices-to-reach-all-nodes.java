class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];

        for(int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).get(0);
            int v = edges.get(i).get(1);

            inDegree[v]++;
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(inDegree[i] == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}