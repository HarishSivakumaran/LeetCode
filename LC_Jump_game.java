// 45. Jump Game II

class Solution {
    public int jump(int[] nums) {

        if (nums.length == 1)
            return 0;

        int l = 0, r = nums[0], count = 1;
        int max = 0;

        while (r < nums.length - 1) {
            count++;
            max = 0;
            while (l <= r) {
                max = Math.max(max, nums[l] + l++);
            }
            r = max;
        }

        return count;
    }
}