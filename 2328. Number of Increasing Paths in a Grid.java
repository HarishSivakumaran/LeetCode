class Solution {
    Long[][] cache = null;
    int[][] dir = {{0,1}, {1,0}, {0,-1},{-1,0}};
    int mod = 1000000007;
    public int countPaths(int[][] grid) {
        long ans = 0;
        cache = new Long[grid.length][grid[0].length];
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                ans += getWays(r, c, grid, 0);
                ans %= mod;
            }
        }

        return (int)ans;
    }

    public long getWays(int r, int c, int[][] grid, int prev){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || 
        grid[r][c] <= prev) return 0;
        if(cache[r][c] != null) return cache[r][c];
        long ans = 0;
        for(int[] d : dir){
            ans += (getWays(r+d[0], c+d[1], grid, grid[r][c]) % mod);
        }

        ans++;

        return cache[r][c] = ans;
    }
}