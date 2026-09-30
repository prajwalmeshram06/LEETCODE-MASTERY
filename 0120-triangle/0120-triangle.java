class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][];

        for(int i = 0; i < triangle.size(); i++) {
            dp[i] = new int[triangle.get(i).size()];
        }

        int last = triangle.size() - 1;

        for(int j = 0; j < triangle.get(last).size(); j++) {
            dp[last][j] = triangle.get(last).get(j);
        }

        for(int i = triangle.size() - 2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[i][j] = triangle.get(i).get(j) + + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }

        return dp[0][0];
    }
}