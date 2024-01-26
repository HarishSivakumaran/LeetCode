class Solution {
    int[][] dir = {{0,1}, {1, 0}, {0,-1}, {-1, 0}};
    Integer[][][] cache;
    int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new Integer[m][n][maxMove+1];
        return dfs(m ,n, startRow, startColumn, maxMove);
    }

    private int dfs(int m, int n, int i, int j, int remMoves) {
        if(i < 0 || j < 0 ||i >= m || j >= n) return 1;
        if(remMoves == 0) return 0;
        if(cache[i][j][remMoves] != null) return cache[i][j][remMoves];

        int ans = 0;
        for(int[] d : dir) {
            ans += dfs(m, n, i+d[0], j+d[1], remMoves-1);
            ans %= mod;
        }

        return cache[i][j][remMoves] = ans;
    }
}