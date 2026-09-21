class Solution {
    public int maxEvents(int[][] events) {
        int ans = 0;

        Arrays.sort(events, (a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int[] next = new int[100002];

        for (int i = 0; i < next.length; i++) {
            next[i] = i;
        }

        for (int i = 0; i < events.length; i++) {
            int start = events[i][0];
            int end = events[i][1];

            int day = find(next, start);

            if (day <= end) {
                ans++;
                next[day] = find(next, day + 1);
            }
        }

        return ans;
    }

    private int find(int[] next, int x) {
        if (next[x] == x)
            return x;

        next[x] = find(next, next[x]);
        return next[x];
    }
}