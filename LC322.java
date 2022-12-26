// 322. Coin Change

class Solution {
    public int coinChange(int[] coins, int amount) {
    if (amount < 0 || coins.length == 0 || coins == null) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

     for(int i = 1; i <= amount; i++ ){
         for(int j : coins){
             if(i < j){
                 continue;
             }else{
                 dp[i] = Math.min(dp[i], 1 + dp[i-j]);
             }
         }
     }

     return dp[amount] != amount + 1 ? dp[amount] : -1;
        
    }


}