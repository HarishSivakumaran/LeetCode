// 1470. Shuffle the Array

class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i = n; i < 2 * n; i++) {
            nums[i - n] |= nums[i] << 10;
        }

        int allOnes = (1 << 10) - 1;
        for (int i = n - 1; i >= 0; i--) {
            int firstNum = nums[i] & allOnes;
            int secNum = nums[i] >> 10;
            nums[2 * i] = firstNum;
            nums[(2 * i) + 1] = secNum;
        }

        return nums;
        // int[] out = new int[nums.length];
        // for(int i = 0, k = 0, j = n; i < nums.length; i+=2){
        // out[i] = nums[k++];
        // out[i+1] = nums[j++];
        // }

        // return out;
    }
}