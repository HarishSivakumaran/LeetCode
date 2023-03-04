// 2444. Count Subarrays With Fixed Bounds

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int leftBound = -1, minIndex = -1, maxIndex = -1;
        long count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= maxK && nums[i] >= minK) {
                minIndex = nums[i] == minK ? i : minIndex;
                maxIndex = nums[i] == maxK ? i : maxIndex;
                count += Math.max(0, Math.min(minIndex, maxIndex) - leftBound);
            } else {
                leftBound = i;
                minIndex = -1;
                maxIndex = -1;
            }
        }

        return count;
    }
}