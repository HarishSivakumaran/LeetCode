class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1, m = 0;

        while(l <= r) {
            m = l + (r-l)/2;

            if(nums[m] == target) return true;

            if(nums[m] == nums[l]) {
               l++;
               continue;
            }

            // left sorted array
            if(nums[m] >= nums[l]) {
                if(target > nums[m] || target < nums[l]) {
                    l = m+1;
                } else {
                    r = m-1;
                }
                continue;
            }

            // right sorted array
            if(nums[m] <= nums[r]) {
                if(target < nums[m] || target > nums[r]) {
                    r = m-1;
                } else {
                    l = m+1;
                }
            }
        }

        return false;
    }
}