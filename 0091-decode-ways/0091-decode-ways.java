class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        int i = 0;

        if(s.charAt(0) == '0') {
            return 0;
        }

        dp[0] = 1;

        while(i < s.length()) {
            if(i > 0 && (s.charAt(i) - '0') > 0) {
                dp[i] += dp[i - 1];
            }

            if(i > 0 && s.charAt(i - 1) != '0' &&
               (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0') <= 26) {

                if(i == 1) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i - 2];
                }
            }

            i++;
        }

        return dp[s.length() - 1];
    }
}