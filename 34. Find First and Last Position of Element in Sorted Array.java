class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{getMinPos(nums, target), getMaxPos(nums, target)};
    }

    private int getMinPos(int[] nums, int target) {
        int l = 0, r = nums.length-1, m = 0;

        while(l <= r) {
            m = l + (r-l)/2;
            if(nums[m] >= target) {
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return (l >= 0 && l < nums.length && nums[l] == target) ? l : -1;
    }

    private int getMaxPos(int[] nums, int target) {
        int l = 0, r = nums.length-1, m = 0;

        while(l <= r) {
            m = l + (r-l)/2;
            if(nums[m] > target) {
                r = m-1;
            } else {
                l = m+1;
            }
        }

        return (r >= 0 && r < nums.length && nums[r] == target) ? r : -1;
    }
}