class Solution {
    public int reverse(int x) {
        boolean ifnegative = false;

        if (x < 0) {
            ifnegative = true;
            x = -x;
        }

        long num = x;
        long ans = 0;

        while (num > 0) {
            ans = ans * 10 + (num % 10);
            num = num / 10;
        }

        if (ifnegative) {
            ans = -ans;
        }

        if (ans < -(1L << 31) || ans > (1L << 31) - 1) {
            return 0;
        }

        return (int) ans;
    }
}