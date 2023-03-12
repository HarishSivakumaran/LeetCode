// 1838. Frequency of the Most Frequent Element

class Solution {
    public int maxFrequency(int[] nums, int k) {
        int l = 0, r = 0, max = 1;
        long sum = 0;
        Arrays.sort(nums);

        while (r < nums.length) {
            if (k + sum >= (r - l) * nums[r]) {
                max = Math.max(max, r - l + 1);
                sum += nums[r++];
            } else {
                sum -= nums[l++];
            }
        }

        return max;
    }
}