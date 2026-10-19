
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int startHealth = health - grid.get(0).get(0);
        if (startHealth <= 0) return false;

        int[][] best = new int[m][n];
        for (int[] row : best) {
            Arrays.fill(row, -1);
        }

        best[0][0] = startHealth;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, startHealth});

        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];
            int hp = curr[2];

            if (r == m - 1 && c == n - 1) {
                return true;
            }

            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                int nextHp = hp - grid.get(nr).get(nc);

                if (nextHp <= 0) continue;

                if (nextHp > best[nr][nc]) {
                    best[nr][nc] = nextHp;
                    queue.offer(new int[]{nr, nc, nextHp});
                }
            }
        }

        return false;
    }
}
