// 643. Maximum Average Subarray I

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l = 0, r = 0, sum = 0;
        double ans = Integer.MIN_VALUE;
        while (r < k) {
            sum += nums[r];
            r++;
        }
        r--;
        ans = Math.max(ans, (double) sum / k);
        while (r < nums.length - 1) {
            sum -= nums[l++];
            sum += nums[++r];
            ans = Math.max(ans, (double) sum / k);
        }

        return ans;

    }
}