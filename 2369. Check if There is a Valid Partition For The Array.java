class Solution {
    public boolean validPartition(int[] nums) {
        boolean[] doable = new boolean[nums.length+1];
        doable[nums.length] = true;

        for(int i = nums.length-2; i >= 0; i--) {
            //check for rule-1
            doable[i] |= (nums[i] == nums[i+1]) && doable[i+2];

            // rule-2
            doable[i] |= ((i+2 < nums.length) && (nums[i] == nums[i+1])
             && (nums[i] == nums[i+2]) && doable[i+3]);

            // rule-3
            doable[i] |= ((i+2 < nums.length) && (nums[i+1] == 1 + nums[i]) && (nums[i+2] == 2 + nums[i]) && doable[i+3]);
        }

        return doable[0];
    }
}