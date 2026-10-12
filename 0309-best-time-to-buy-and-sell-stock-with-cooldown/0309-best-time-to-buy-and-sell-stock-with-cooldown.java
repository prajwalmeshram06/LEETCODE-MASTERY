class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] sold = new int[n + 1];
        int[] hold = new int[n + 1];
        int[] rest = new int[n + 1];

        hold[0] = -prices[0];
        sold[0] = 0;
        rest[0] = 0;

        for(int i = 1; i < n; i++) {
            sold[i] = hold[i - 1] + prices[i];
            hold[i] = Math.max(rest[i - 1] - prices[i], hold[i - 1]);
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
        }

        return Math.max(sold[n - 1], rest[n - 1]);
    }
}