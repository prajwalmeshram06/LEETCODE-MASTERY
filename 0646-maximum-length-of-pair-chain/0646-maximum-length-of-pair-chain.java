class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b) -> Integer.compare(a[0], b[0]));

        int[] dp = new int[pairs.length];

        Arrays.fill(dp, 1);

        int ans = 1;

        for(int i = 0; i < pairs.length; i++) {
            for(int j = 0; j < i; j++) {
                if(pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}