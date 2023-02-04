// 486. Predict the Winner

class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int optimalP1Points = canP1Win(nums, 0, nums.length - 1, new Integer[nums.length][nums.length]);
        int t = 0;
        for (int n : nums) {
            t += n;
        }

        return optimalP1Points >= t - optimalP1Points;

    }

    public int canP1Win(int[] nums, int l, int r, Integer[][] dp) {
        if (l > r)
            return 0;

        if (l == r)
            return nums[l];

        if (dp[l][r] != null)
            return dp[l][r];

        int p1Points = Math.max(nums[l] + Math.min(canP1Win(nums, l + 2, r, dp), canP1Win(nums, l + 1, r - 1, dp)),
                nums[r] + Math.min(canP1Win(nums, l, r - 2, dp), canP1Win(nums, l + 1, r - 1, dp)));

        return dp[l][r] = p1Points;

    }
}