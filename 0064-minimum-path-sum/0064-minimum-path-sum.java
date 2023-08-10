class Solution {
    public int minPathSum(int[][] grid) {
        int xLength = grid[0].length;
        int yLength = grid.length;

        int cost[][] = new int[yLength][xLength];

        cost[0][0] = grid[0][0];

        for (int i = 1; i < xLength; i++) {
            cost[0][i] = grid[0][i] + cost[0][i-1];
        }

        for (int i = 1; i < yLength; i++) {
            cost[i][0] = grid[i][0] + cost[i-1][0];

        }

        for (int y = 1; y < yLength; y++) {
            for (int x = 1; x < xLength; x++) {
                cost[y][x] = Math.min(cost[y][x - 1], cost[y - 1][x]) + grid[y][x];
            }
        }

        return cost[yLength - 1][xLength - 1];
    }
}