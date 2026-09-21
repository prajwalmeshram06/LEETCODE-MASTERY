class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int cnt = 0;
        int end = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {

            if(end <= intervals[i][0]) {
                end = intervals[i][1];
            } else {
                cnt++;
            }

        }

        return cnt;
    }
}