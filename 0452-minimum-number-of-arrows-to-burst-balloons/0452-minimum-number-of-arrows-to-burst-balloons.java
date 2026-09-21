class Solution {
    public int findMinArrowShots(int[][] points) {

        int cnt = 0;

        Arrays.sort(points, (a,b) -> {
            if(a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int end = points[0][1];

        for(int i = 1; i < points.length; i++) {
            if(end < points[i][0]) {
                end = points[i][1];
                cnt++;
            }

        }

        return cnt + 1;


    }
}