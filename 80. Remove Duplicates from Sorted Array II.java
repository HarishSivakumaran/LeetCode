class Solution {
    public int removeDuplicates(int[] nums) {
        int[] prev = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int insPtr = 0, travPtr = 0;

        while(travPtr < nums.length) {
            if(nums[travPtr] != prev[0] || nums[travPtr] != prev[1]) {
                prev[0] = prev[1];
                prev[1] = nums[travPtr];
                nums[insPtr] = nums[travPtr];
                insPtr++;
            }
            travPtr++;
        }

        return insPtr;
    }
}