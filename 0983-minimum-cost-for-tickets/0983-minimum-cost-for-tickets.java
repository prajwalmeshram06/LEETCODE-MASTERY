class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int[] dp = new int[days.length];

        dp[0] = Math.min(costs[0], Math.min(costs[1], costs[2]));

        for(int i = 1; i < days.length; i++) {
            
            int j = i - 1;
            while(j >= 0 && days[j] >= days[i] - 6) {
                j--;
            }

            int k = i - 1;
            while(k >= 0 && days[k] >= days[i] - 29) {
                k--;
            }

            int seven = costs[1];
            int thirty = costs[2];

            if(j >= 0) seven += dp[j];
            if(k >= 0) thirty += dp[k];

            dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(seven, thirty));
        }

        return dp[days.length - 1];

        

    }
}