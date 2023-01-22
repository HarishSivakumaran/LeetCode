// 313. Super Ugly Number

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[primes.length];
        long[] dp = new long[n];

        dp[0] = 1; // 0th ugly num is 1

        for(int i = 1; i < n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                dp[i] = Math.min(dp[i], primes[j]*dp[index[j]]);
            }

            for(int j = 0; j < primes.length; j++){
                if(dp[i] == primes[j]*dp[index[j]]) index[j]++;
            }
        }

        return (int)dp[n-1];
    }
}
