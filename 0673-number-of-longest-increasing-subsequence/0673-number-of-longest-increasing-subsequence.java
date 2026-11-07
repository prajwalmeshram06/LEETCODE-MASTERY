class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;

        int max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] count = new int[n];
        Arrays.fill(count, 1);

        int ans = 0;

        for(int i = 1; i < n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) {
                    if(dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }
                    else if(dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }

                    max = Math.max(max, dp[i]);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(dp[i] == max) {
                ans += count[i];
            }
        }

        return ans;
    }
}