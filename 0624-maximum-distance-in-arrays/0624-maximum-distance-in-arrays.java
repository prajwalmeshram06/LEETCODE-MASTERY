class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();

        List<Integer> min = new ArrayList<>();
        List<Integer> max = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int minn = Integer.MAX_VALUE;
            int maxx = Integer.MIN_VALUE;
            for(int j = 0; j < arrays.get(i).size(); j++) {
                if(arrays.get(i).get(j) < minn) {
                    minn = arrays.get(i).get(j);
                }
                if(arrays.get(i).get(j) > maxx) {
                    maxx = arrays.get(i).get(j);
                }
            }
            min.add(minn);
            max.add(maxx);
        }

        int ans = 0;
        int minSoFar = min.get(0);
        int maxSoFar = max.get(0);

        for(int i = 1; i < n; i++) {
            ans = Math.max(ans, Math.abs(max.get(i) - minSoFar));
            ans = Math.max(ans, Math.abs(maxSoFar - min.get(i)));

            minSoFar = Math.min(minSoFar, min.get(i));
            maxSoFar = Math.max(maxSoFar, max.get(i));
        }

        return ans;
    }
}