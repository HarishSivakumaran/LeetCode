class Solution {
    public int[][] divideArray(int[] nums, int k) {
        if(nums.length%3 != 0) return new int[][]{};
        int[][] out = new int[nums.length/3][3];
        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length) {
            if(i%3 == 0) {
                //start
                out[i/3][i%3] = nums[i];
            } else if (-out[i/3][0]+nums[i] <= k){
                out[i/3][i%3] = nums[i];
            } else {
                return new int[][]{};
            }
            i++;
        }

        return out;
    }
}