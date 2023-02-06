// 1470. Shuffle the Array

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] out = new int[nums.length];
        for (int i = 0, k = 0, j = n; i < nums.length; i += 2) {
            out[i] = nums[k++];
            out[i + 1] = nums[j++];
        }

        return out;
    }
}