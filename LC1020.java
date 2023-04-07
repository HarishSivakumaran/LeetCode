class Solution {
    boolean reachedBound = false;
    int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int numEnclaves(int[][] grid) {
        int ans = 0, l = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                reachedBound = false;
                if (grid[r][c] == 1) {
                    l = dfs(r, c, grid);
                    if (!reachedBound) {
                        ans += l;
                    }
                }
            }
        }

        return ans;
    }

    public int dfs(int r, int c, int[][] grid) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
            reachedBound = true;
            return 0;
        }

        if (grid[r][c] != 1)
            return 0;

        grid[r][c] = 0;

        int len = 1;

        for (int[] d : dir) {
            len += dfs(r + d[0], c + d[1], grid);
        }

        return len;

    }
}