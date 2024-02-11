class Solution {
    int[][] dir = { { 1, -1 }, { 1, 0 }, { 1, 1 } };
    Integer[][][][] cache;

    public int cherryPickup(int[][] grid) {
        cache = new Integer[grid.length][grid[0].length][grid.length][grid[0].length];
        return dfs(0, 0, 0, grid[0].length - 1, grid);
    }

    private int dfs(int r1, int c1, int r2, int c2, int[][] grid) {
        if(cache[r1][c1][r2][c2] != null) return cache[r1][c1][r2][c2];
        
        int val = grid[r1][c1];
        if (r1 != r2 || c1 != c2) {
            val += grid[r2][c2];
        }
        if (r1 == grid.length - 1)
            return val;

        int max = 0;
        for (int[] d : dir) {
            int nR1 = r1 + d[0], nC1 = c1 + d[1];
            if (nC1 >= 0 && nC1 < grid[0].length) {
                for (int[] d1 : dir) {
                    int nR2 = r2 + d1[0], nC2 = c2 + d1[1];
                    if (nC2 >= 0 && nC2 < grid[0].length) {
                        max = Math.max(max, val + dfs(nR1, nC1, nR2, nC2, grid));
                    }
                }
            }
        }

        return cache[r1][c1][r2][c2] = max;

    }
}

/**
 * class Solution {
 * public int cherryPickup(int[][] grid) {
 * int[] pos = { 0, 0, 0, grid[0].length - 1, grid[0][0] +
 * grid[0][grid[0].length - 1] };
 * int[][] dir = { { 1, -1 }, { 1, 0 }, { 1, 1 } };
 * int ans = 0;
 * 
 * Queue<int[]> q = new LinkedList();
 * q.add(pos);
 * 
 * while (!q.isEmpty()) {
 * int len = q.size();
 * while (len-- > 0) {
 * int[] curr = q.poll();
 * if (curr[0] == grid.length - 1) {
 * ans = Math.max(ans, curr[4]);
 * continue;
 * }
 * for (int[] d : dir) {
 * int nR1 = curr[0] + d[0], nC1 = curr[1] + d[1];
 * if (nC1 >= 0 && nC1 < grid[0].length) {
 * for (int[] d1 : dir) {
 * int nR2 = curr[2] + d1[0], nC2 = curr[3] + d1[1];
 * if (nC2 >= 0 && nC2 < grid[0].length) {
 * int val = curr[4] + grid[nR1][nC1];
 * if (nR1 != nR2 || nC1 != nC2) {
 * val += grid[nR2][nC2];
 * }
 * q.add(new int[] { nR1, nC1, nR2, nC2, val });
 * }
 * }
 * }
 * }
 * }
 * }
 * return ans;
 * 
 * }
 * }
 * 
 */