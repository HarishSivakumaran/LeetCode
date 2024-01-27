class Solution {
    int mod = 1000000007;
    Long[][] cache;
    public int kInversePairs(int n, int k) {
        cache = new Long[n+1][k+1];
        return (int)getWays(1, n, k);
    }
    
    private long getWays(int i, int n, int k) {
        if(k == 0) return 1;
        if(i > n) return 0;
        if(cache[i][k] != null) return cache[i][k];

        long ans = 0l;
        for(int ins = 0; ins <= Math.min(k, i-1); ins++) {
            ans += getWays(i+1, n, k-ins);
            ans %= mod;
        }

        return cache[i][k] = ans;
    }
}