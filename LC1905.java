// 1905. Count Sub Islands

class Solution {
    int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    boolean check = true;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0;
        for (int r = 0; r < grid2.length; r++) {
            for (int c = 0; c < grid2[0].length; c++) {
                if (grid2[r][c] == 1 && grid1[r][c] == 1) {
                    dfs(grid1, grid2, r, c);
                    ans += check ? 1 : 0;
                    check = true;
                }
            }
        }

        return ans;

    }

    public void dfs(int[][] grid1, int[][] grid2, int r, int c) {
        if (r < 0 || c < 0 || r >= grid1.length || c >= grid1[0].length || grid2[r][c] == 0)
            return;
        if (grid1[r][c] == 0) {
            check = false;
        }
        grid1[r][c] = 0;
        grid2[r][c] = 0;
        for (int[] d : dir) {
            dfs(grid1, grid2, r + d[0], c + d[1]);
        }
        return;
    }
}