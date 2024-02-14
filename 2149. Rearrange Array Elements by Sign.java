class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] out = new int[nums.length];
        int i = 0, p = 0, n = 1;
        while(i < nums.length) {
            if(nums[i] < 0) {
                out[n] = nums[i];
                n += 2;
            } else {
                out[p] = nums[i];
                p += 2;
            }
            i++;
        }

        return out;
    }
}