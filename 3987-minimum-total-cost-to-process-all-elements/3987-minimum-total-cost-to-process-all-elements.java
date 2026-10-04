class Solution {
    public int minimumCost(int[] nums, int k) {

        long sum = 0;

        for (int num : nums) {
            sum += num;
        }

        long cnt = (sum + k - 1) / k - 1;

        long MOD = 1000000007;

        cnt %= MOD;

        return (int)(cnt * ((cnt + 1) % MOD) % MOD * 500000004 % MOD);
    }
}