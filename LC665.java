// 665. Non-decreasing Array

class Solution {
    public boolean checkPossibility(int[] nums) {
        int k = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (k == 0)
                    return false;
                k--;
                if (i - 1 >= 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                }
            }
        }
        return true;

    }
}