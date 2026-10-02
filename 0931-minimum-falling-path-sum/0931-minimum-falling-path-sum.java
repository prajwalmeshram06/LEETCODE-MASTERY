class Solution {
    public int minFallingPathSum(int[][] mx) {
        
        int m = mx.length;
        int n = mx[0].length;

        for(int i = 1; i < mx.length; i++) {
            for(int j = 0; j < mx[i].length; j++) {
                if(j == 0) {
                    mx[i][j] = mx[i][j] + Math.min(mx[i - 1][j], mx[i - 1][j + 1]); 
                } else if(j == mx[0].length - 1) {
                    mx[i][j] = mx[i][j] + Math.min(mx[i - 1][j], mx[i - 1][j - 1]);
                } else {
                    mx[i][j] = mx[i][j] + Math.min(mx[i - 1][j - 1], Math.min(mx[i - 1][j], mx[i - 1][j + 1]));
                }
            }
        }

        int minPath = Integer.MAX_VALUE;

        for(int j = 0; j < mx[mx.length - 1].length; j++) {
            minPath = Math.min(minPath, mx[mx.length - 1][j]);
        }

        return minPath;
    }
}