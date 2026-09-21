class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {

        int n = reward1.length;

        int[][] r = new int[n][2];

        int total = 0;

        for(int i = 0; i < n; i++) {
            total += reward2[i];

            r[i][0] = reward1[i] - reward2[i];
            r[i][1] = i;
        }

        Arrays.sort(r, (a, b) -> Integer.compare(a[0], b[0]));

        for(int i = n - 1; i >= n - k; i--) {
            total += r[i][0];
        }

        return total;
    }
}