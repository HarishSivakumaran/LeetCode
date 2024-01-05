class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] incLen = new int[nums.length];
        int max = 0;
        for(int i = nums.length-1; i >= 0; i--) {
            int len = 0;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j] > nums[i] && incLen[j] > len) len = incLen[j];
            }
            incLen[i] = len+1;
            if(incLen[i] > max) max = incLen[i];
        }
        return max;
    }
}