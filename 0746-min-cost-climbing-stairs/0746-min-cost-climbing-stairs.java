class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length + 1;

        List<Integer> costs = new ArrayList<>();
        costs.add(0);
        costs.add(0);

        for (int i = 2; i < n; i++) {
            int min = Math.min(costs.get(i - 1) + cost[i - 1], costs.get(i - 2) + cost[i - 2]);
            costs.add(min);
        }

        return costs.get(n-1);
    }
}