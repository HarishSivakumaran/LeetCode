// 279. Perfect Squares

class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        dp[1] = 1;

        if(Math.pow((int)Math.sqrt(n),2) == n) return 1;

        for(int j = 2; j <= n; j++){
            for(int i = 1; i <=  Math.ceil(Math.sqrt(j)); i++ ){
                if((i*i) <= j)
                    dp[j] = Math.min(dp[j], 1+ dp[j - (i*i)]);
            }
        }

        return dp[n];
        
    }
}
