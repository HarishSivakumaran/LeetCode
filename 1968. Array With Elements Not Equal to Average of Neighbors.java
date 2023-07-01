class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] out = new int[nums.length];
        Arrays.sort(nums);
        int l = 0, r = nums.length-1, i = 0;

        while(l < r){
            out[i++] = nums[l++];
            out[i++] = nums[r--];
        }

        if(i < nums.length) out[i++] = nums[l];

        return out;
    }
}