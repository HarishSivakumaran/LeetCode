// 152. Maximum Product Subarray

class Solution {
    public int maxProduct(int[] nums) {
        int[] dp = {1,1};
        int maxVal = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        
        for(int n : nums){
            maxVal = Math.max(n, maxVal);
            if(n != 0){ 
                int tmp = dp[1] * n;
                dp[1] = Math.max(n, Math.max(tmp, dp[0] * n));
                dp[0] = Math.min(n, Math.min(tmp, dp[0] * n));
                res = Math.max(res, dp[1]);
            } else  {
                dp = new int[]{1,1};
            }
        }
        return res > maxVal ? res : maxVal;
    }
}