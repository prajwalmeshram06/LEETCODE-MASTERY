class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        int maxSum = 0;
        
        for(int i = 0; i <= n; i++) {
            int maxVal = 0;
            for(int j = 1; j <= k && j <= i; j++) {
                maxVal = Math.max(maxVal, arr[i -j]);
                dp[i] = Math.max(dp[i], dp[i - j] + maxVal * j);
            }
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
        
    }
}