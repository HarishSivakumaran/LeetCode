// 312. Burst Balloons

class Solution {
    public int maxCoins(int[] nums) {     
        int[][] dp = new int[nums.length][nums.length];

        return bb(nums, 0, nums.length-1, dp);
                
    }

    public int bb(int[] nums, int l, int r,  int[][] dp){

        if(l > r) return 0;

        if(dp[l][r] > 0) return dp[l][r];

         int coins = 0;

        for(int i = l; i <= r; i++){
            coins = nums[i];

            if(l > 0){
                coins *= nums[l-1];
            }

             if(r < nums.length-1){
                coins *= nums[r+1];
            }

            coins += bb(nums, l, i-1, dp) + bb(nums, i+1, r, dp);

            dp[l][r] = Math.max(dp[l][r],coins);
        }

        return dp[l][r] ;
    }
}