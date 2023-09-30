class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int insPtr = 0;
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & 1) == 0) {
                //even
                int temp = nums[i];
                nums[i] = nums[insPtr];
                nums[insPtr++] = temp;
            }
        }

        return nums;
    }
} 