class Solution {
    int mod = 1000000007;
    Long[][] cache = null;
    public int numRollsToTarget(int n, int k, int target) {
        cache = new Long[n][target+1];
        return (int)getRolls(0, target, k , n);
    }

    private long getRolls(int i, int target, int k, int n) {
        if(i >= n && target == 0) return 1;
        if(target <= 0 || i >= n) return 0;

        if(cache[i][target] != null) return cache[i][target];

        long ans = 0;
        for(int j = 1; j <= k && j <= target; j++) {
            ans += getRolls(i+1, target-j, k, n);
            ans %= mod;
        }

        return cache[i][target] = ans;
    }
}