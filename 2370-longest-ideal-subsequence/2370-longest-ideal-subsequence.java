// class Solution {
//     public int longestIdealString(String s, int k) {
//         int max = 1;
//         int[] dp = new int[s.length()];

//         int n = s.length();

//         for(int i = 0; i < n; i++) {
//             dp[i] = 1;
//         }

//         for(int i = 0; i < n; i++) {
//             for(int j = i - 1; j >= 0; j--) {
//                 if(Math.abs(s.charAt(i) - s.charAt(j)) <= k) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
//                 }
//             }
//             max = Math.max(max, dp[i]);
//         }

//         return max;
//     }
// }

class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int max = 0;

        for(int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i) - 'a';

            int best = 0;

            for(int j = Math.max(0, ch - k); j <= Math.min(25, ch + k); j++) {
                best = Math.max(best, dp[j]);
            }

            dp[ch] = best + 1;
            max = Math.max(max, dp[ch]);
        }

        return max;
    }
}