class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        int prevMax = Integer.MAX_VALUE;

        for(int i = nums.length-1; i >= 0; i--) {
            if(nums[i] <= prevMax) {
                prevMax = nums[i];
                continue;
            } else {
                int divs = (int)Math.ceil((double)nums[i]/prevMax);
                ans += (divs-1);
                prevMax = nums[i]/divs;
            }
        }

        return ans;
    }
}