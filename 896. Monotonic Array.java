class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length < 2) return true;
        Boolean isNonDecreasing = null; // no pattern found

        for(int i = 0; i < nums.length-1; i++) {
            if(isNonDecreasing == null) {
                if(nums[i] > nums[i+1]) {
                    isNonDecreasing = false;
                } else if(nums[i] < nums[i+1]) {
                    isNonDecreasing = true;
                }
            } else {
                if(isNonDecreasing && nums[i+1] < nums[i]) {
                    return false;
                }

                if(!isNonDecreasing && nums[i+1] > nums[i]) {
                    return false;
                }
            }
        }

        return true;
    }
}