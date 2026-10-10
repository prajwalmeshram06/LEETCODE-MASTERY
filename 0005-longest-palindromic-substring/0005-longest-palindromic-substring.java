class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);

        String s2 = sb.reverse().toString();

        int m = s.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        int end = 0;

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    int len = dp[i][j];

                    if(i - len == m - j && len > ans) {
                        ans = len;
                        end = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return s.substring(end - ans, end);
    
    }
}