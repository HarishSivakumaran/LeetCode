// 1254. Number of Closed Islands

class Solution {
    int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int closedIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 0 && !dfs(i, j, grid)) {
                    ans++;
                }

            }
        }

        return ans;
    }

    public boolean dfs(int r, int c, int[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
            return true;

        if (grid[r][c] != 0)
            return false;

        grid[r][c] = 2;
        boolean b = false;
        for (int[] d : dir) {
            if (dfs(r + d[0], c + d[1], grid)) {
                b = true;
            }
        }

        return b;
    }
}