
class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] arr = new int[scores.length][2];

        for(int i = 0; i < scores.length; i++) {
            arr[i][0] = scores[i];
            arr[i][1] = ages[i];
        }

        Arrays.sort(arr, (a, b) -> {
            if(a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int n = scores.length;
        int[] dp = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++) {
            dp[i] = arr[i][0];

            for(int j = 0; j < i; j++) {
                if(arr[j][1] <= arr[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][0]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
