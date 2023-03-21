// 2348. Number of Zero-Filled Subarrays

class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res += ((long) (i - left) * (long) (i - left + 1)) / 2;
                left = i + 1;
            }
        }
        if (left < nums.length) {
            res += ((long) (nums.length - left) * (long) (nums.length - left + 1)) / 2;
        }
        return res;

    }
}