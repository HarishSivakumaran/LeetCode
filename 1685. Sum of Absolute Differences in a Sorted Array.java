class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] prefixSum = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            prefixSum[i] = (i-1 >= 0 ? prefixSum[i-1]:0) + nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = (i*nums[i])-(i-1 >= 0 ? prefixSum[i-1] : 0) + 
                      (prefixSum[nums.length-1]-prefixSum[i]) -
                      ((nums.length-1-i)*nums[i]);
        }

        return nums;
    }
}