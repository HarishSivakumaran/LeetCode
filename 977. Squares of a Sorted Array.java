class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        while(l < nums.length && nums[l] < 0) l++;
        int[] out = new int[nums.length];
        int i = 0, r = l; l = l-1;
        while(l >= 0 || r < nums.length) {
            if(r >= nums.length || (l >= 0 && (nums[l]*nums[l]) < (nums[r]*nums[r]))) {
                out[i] = (nums[l]*nums[l]);
                l--;
            } else {
                out[i] = nums[r] * nums[r];
                r++;
            }
            i++;
        }

        return out;
    }
}