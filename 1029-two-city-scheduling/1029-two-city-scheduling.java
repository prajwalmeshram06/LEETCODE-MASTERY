class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int minCost = 0;

        Arrays.sort(costs, (a,b) ->
            Integer.compare(a[0] - a[1], b[0] - b[1])
        );

        for(int i = 0; i < costs.length / 2; i++) {
            minCost += costs[i][0];
        }

        for(int i = costs.length / 2; i < costs.length; i++) {
            minCost += costs[i][1];
        }

        return minCost;
    }
}