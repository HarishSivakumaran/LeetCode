class Solution {
    int[][] dir = {{0, 1}, {1, 0}};
    Integer[][] cache = null;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        cache = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return getWays(obstacleGrid, 0, 0);
    }

    private int getWays(int[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || 
        c >= grid[0].length || grid[r][c] == 1) return 0;

        if(r == grid.length-1 && c == grid[0].length-1) return 1;

        if(cache[r][c] != null) return cache[r][c];

        int ways = 0;

        for(int[] d : dir){
            ways += getWays(grid, r+d[0], c+d[1]);
        }

        return cache[r][c] = ways;
    }
}