class Solution {
    public int maximumScore(int[] nums, int k) {
        int ans = 0;
        int l = k, r = k, min = nums[k],  left = 0, right = 0;

        while(l >= 0 && r < nums.length) {
            min = Math.min(min, Math.min(nums[l], nums[r]));
            ans = Math.max(ans, min*(r-l+1));

            left = l-1 >= 0 ? nums[l-1] : 0;
            right = r+1 < nums.length ? nums[r+1] : 0;
            if(right > left) {
                r++;
            } else {
                l--;
            }
        }

        return ans;
    }
}