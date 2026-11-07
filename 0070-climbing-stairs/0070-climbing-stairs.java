class Solution {
    public int climbStairs(int n) {
        if(n <= 1) {
            return n;
        }
        int p = 1;
        int m = 2;

        for(int i = 3; i <= n; i++) {
            int a = p + m;
            p = m;
            m = a;
        }

        return m;
    }
}