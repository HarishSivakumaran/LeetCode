class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max = -1;
        int l = 0, r = nums.length-1;
        while(l < r) {
            if(nums[l]+nums[r] > max) max = nums[l]+nums[r];
            l++; r--;
        }

        return max;
    }
}