// 540. Single Element in a Sorted Array

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, m = 0, prev = 0, after = 0;

        while (l <= r) {
            m = l + (r - l) / 2;
            prev = m - 1 >= 0 ? nums[m - 1] : -1;
            after = m + 1 < nums.length ? nums[m + 1] : Integer.MAX_VALUE;

            if (nums[m] != prev && nums[m] != after)
                return nums[m];

            // if left is even and the number repeats on it's left
            if ((m - l) % 2 == 0) {
                if (nums[m] == prev) {
                    r = m - 2;
                } else {
                    l = m + 2;
                }
            } else {
                if (nums[m] == prev) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }

            }
        }

        return -1;
    }
}