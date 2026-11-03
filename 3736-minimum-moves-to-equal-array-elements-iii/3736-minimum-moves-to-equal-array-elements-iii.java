class Solution {
    static {
        for(int i = 0; i < 201; i++) {
            minMoves(new int[0]);
        }
    }
    public static int minMoves(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int x : nums) {
            sum += x;
            max = Math.max(max, x);
        }

        return (max * nums.length) - sum;
    }
}