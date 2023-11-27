class Solution {

    int[][] keyPad = {{1,2,3}, {4,5,6}, {7,8,9}, {-1, 0, -1}};
    int[][] jumpDirs = {{2, 1}, {2, -1}, {-2, 1}, {-2,-1}, {1, 2}, 
    {-1,2}, {1,-2}, {-1, -2}};
    int mod = 1000000007;

    Long[][] cache = null;

    public int knightDialer(int n) {
        long ans = 0;
        cache = new Long[n+1][10];
        for(int r = 0; r < keyPad.length; r++) {
            for(int c = 0; c < keyPad[0].length; c++) {
                if(keyPad[r][c] != -1) {
                    ans += getWays(r, c, n);
                    ans %= mod;
                }
            }
        }

        return (int) ans;
    }

    private long getWays(int r, int c, int currLen) {
        if(1 == currLen) return 1;
        if(cache[currLen][keyPad[r][c]] != null) return cache[currLen][keyPad[r][c]] ;
        long ans = 0;
        for(int[] d : jumpDirs) {
            int nextR = r + d[0], nextC = c+d[1];
            if(nextR < 0 || nextR >= keyPad.length || nextC < 0 || 
               nextC >= keyPad[0].length || keyPad[nextR][nextC] == -1) continue;
            
            ans += getWays(nextR, nextC, currLen-1);
            ans %= mod;

        }

        return cache[currLen][keyPad[r][c]] = ans;
    }
}