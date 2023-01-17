// 96. Unique Binary Search Trees

class Solution {
    public int numTrees(int n) {
        // tot[4] = tot[0] * tot[3] + tot[1] * tot[2] + tot[2] * tot[1] + tot[3] * tot[0]; 
        // tot[2] = tot[0] * tot[1] + tot[1] * tot[0]; 

        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <=n; i++){
            for(int j = 0; j < i; j++){
                int left = j >= 0 ? j : 0;
                int right = i - j - 1;
                dp[i] += (dp[left] * dp[right]);
            }
        }

        return dp[n];
    }
}